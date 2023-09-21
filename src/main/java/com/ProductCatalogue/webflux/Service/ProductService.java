package com.ProductCatalogue.webflux.Service;

import com.ProductCatalogue.webflux.Model.Product;
import com.ProductCatalogue.webflux.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a new product
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    // Retrieve a product by ID
    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Retrieve all products
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Update a product
    public Mono<Product> updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setPrice(updatedProduct.getPrice());
                    return productRepository.save(existingProduct);
                });
    }

    // Delete a product by ID
    public Mono<Void> deleteProductById(Long id) {
        return productRepository.deleteById(id);
    }
}