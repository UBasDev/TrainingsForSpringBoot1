package org.group1.controllers;

import org.group1.dto.CreateSingleProductDto;
import org.group1.dto.UpdateSingleProductByIdDto;
import org.group1.entities.Product;
import org.group1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "get-all-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "get-single-product-by-id")
    public Optional<Product> getSingleProductById(@RequestParam("productId") Long productId) {
        return productService.getSingleProductById(productId);
    }

    @PostMapping(path = "create-single-product")
    public boolean createSingleProduct(@RequestBody CreateSingleProductDto requestBody) {
        return productService.createSingleProduct(requestBody);
    }

    @GetMapping(path = "get-single-product-by-name")
    public Product getSingleProductByName(@RequestParam String productName) {
        return productService.getSingleProductByName(productName);
    }

    @PutMapping(path = "update-single-product-by-id/{productId}")
    public boolean updateSingleProductById(@PathVariable Long productId, @RequestBody UpdateSingleProductByIdDto requestBody) {
        return productService.updateSingleProductById(productId, requestBody);
    }

    @DeleteMapping(path = "delete-single-product-by-id")
    public boolean deleteSingleProductById(@RequestParam("productId") Long productId) {
        return productService.deleteSingleProductById(productId);
    }

    @GetMapping(path = "test1")
    public ResponseEntity test1() {
        productService.test1();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
