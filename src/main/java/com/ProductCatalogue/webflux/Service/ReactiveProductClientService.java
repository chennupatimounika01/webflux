package com.ProductCatalogue.webflux.Service;

import com.ProductCatalogue.webflux.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveProductClientService {
    private final WebClient webClient;

    public ReactiveProductClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://your-api-base-url").build();
    }

    public Mono<Product> getProductById(Long productId) {
        return webClient
                .get()
                .uri("/api/products/{id}", productId)
                .retrieve()
                .bodyToMono(Product.class);
    }

    public Flux<Product> getAllProducts() {
        return webClient
                .get()
                .uri("/api/products")
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<Void> createProduct(Product newProduct) {
        return webClient
                .post()
                .uri("/api/products")
                .body(Mono.just(newProduct), Product.class)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Void> updateProduct(Long productId, Product updatedProduct) {
        return webClient
                .put()
                .uri("/api/products/{id}", productId)
                .body(Mono.just(updatedProduct), Product.class)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Void> deleteProduct(Long productId) {
        return webClient
                .delete()
                .uri("/api/products/{id}", productId)
                .retrieve()
                .bodyToMono(Void.class);
    }
}

