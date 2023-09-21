package com.ProductCatalogue.webflux.Repository;

import com.ProductCatalogue.webflux.Model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

    Flux<Product> findAll();

    Mono<Product> save(Product updatedProduct);

    Mono<Void> deleteById(Long id);

    default Mono<Product> findById(Long id) {
        return null;
    }
}
