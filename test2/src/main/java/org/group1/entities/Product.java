package org.group1.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_sequence")
    private Long id;
    private String name = "";
    private Integer price;


    public Product() {

    }

    public Product(Long id, String name, Integer price, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", deletedDate=" + deletedDate +
                '}';
    }

    public static ProductBuilder buildStart() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private Long id;
        private String name;
        private Integer price;
        private LocalDateTime createdDate;

        private ProductBuilder() {

        }

        public ProductBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(Integer price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Product buildEnd() {
            return new Product(id, name, price, createdDate);
        }
    }
}
