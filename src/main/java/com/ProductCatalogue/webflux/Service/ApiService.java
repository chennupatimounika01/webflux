package com.ProductCatalogue.webflux.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {
    private final WebClient webClient;
    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(WebClient.Builder webClientBuilder, RestTemplate restTemplate) {
        this.webClient = webClientBuilder.baseUrl("http://api-base-url").build();
        this.restTemplate = restTemplate;
    }
    public Mono<String> fetchDataWithWebClient() {
        return webClient
                .get()
                .uri("/endpoint") // Specify the API endpoint
                .retrieve()
                .bodyToMono(String.class); // Convert the response to a Mono<String>
    }
}
