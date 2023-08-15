package org.group1.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.group1.dto.CreateSingleProductDto;
import org.group1.dto.UpdateSingleProductByIdDto;
import org.group1.entities.Product;
import org.group1.repositories.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    //private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final EntityManagerFactory emf;

    @Autowired
    public ProductService(ProductRepository productRepository, EntityManagerFactory emf) {
        this.productRepository = productRepository;
        this.emf = emf;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> getSingleProductById(Long productId) {
        return this.productRepository.findById(productId);
    }

    public boolean createSingleProduct(CreateSingleProductDto requestBody) {

        var createdProduct = this.productRepository.save(Product.buildStart().setName(requestBody.getName()).setPrice(requestBody.getPrice()).setCreatedDate(LocalDateTime.now()).buildEnd());
        return createdProduct != null;
    }

    public Product getSingleProductByName(String productName) {
        return this.productRepository.findFirstByName(productName);
    }

    public boolean updateSingleProductById(Long productId, UpdateSingleProductByIdDto requestBody) {
        var productFromRepository = this.productRepository.findById(productId);
        if (productFromRepository.isEmpty())
            throw new IllegalArgumentException("Product not found with this id: " + productId);
        var productFound = productFromRepository.get();
        productFound.setName(requestBody.getName());
        productFound.setPrice(requestBody.getPrice());
        this.productRepository.save(productFound);
        return true;
    }

    public boolean deleteSingleProductById(Long productId) {
        try {
            this.productRepository.deleteById(productId);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), new StringBuilder().append("Error occurred while deleting product with this id: ").append(productId));
            return false;
        }
    }

    public void test1() {
        var em = this.emf.createEntityManager();
        var x1 = em.find(Product.class, 4);
        var newTransaction = em.getTransaction();
        try {
            newTransaction.begin();
            //var newProduct = Product.buildStart().setId((long) 30).setName("product6").setPrice(60).setCreatedDate(LocalDateTime.now()).buildEnd();
            //var mergedProduct = em.merge(newProduct); //Yeni oluşturulmuş bu objecti merge ediyoruz, yani Persistence Contexte ekliyoruz. Çünkü bu object yeni oluşturulduğu ve databaseden CEKILMEDIGI için `detached` durumundadır. Bu objecti, contexte bu şekilde tanıtırız.
            //em.persist(mergedProduct); //Oluşturulan ve Persistence Contexte tanıtılan bu objecti persist ederek databasee ekleriz.
            var mergedProduct = em.merge(Product.buildStart().setId((long) 29).buildEnd());
            em.remove(mergedProduct);
            newTransaction.commit();
        } catch (Exception ex) {
            if (newTransaction.isActive()) {

                newTransaction.rollback();

                log.error(ex.getMessage());
            }
        } finally {
            em.close();
        }
    }
}
