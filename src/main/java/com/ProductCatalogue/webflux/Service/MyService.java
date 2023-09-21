package com.ProductCatalogue.webflux.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MyService {
    private final WebClient.Builder webClientBuilder;

    public MyService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> fetchDataFromExternalService() {
        WebClient webClient = webClientBuilder.baseUrl("https://api.example.com").build();

        return webClient
                .get()
                .uri("/endpoint") // The specific API endpoint you want to request
                .retrieve()
                .bodyToMono(String.class);
    }
}
