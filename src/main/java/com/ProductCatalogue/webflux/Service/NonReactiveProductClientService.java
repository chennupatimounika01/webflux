package com.ProductCatalogue.webflux.Service;

import com.ProductCatalogue.webflux.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class NonReactiveProductClientService {
    private final RestTemplate restTemplate;

    @Autowired
    public NonReactiveProductClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductById(Long productId) {
        return restTemplate.getForObject("http://your-api-base-url/api/products/{id}", Product.class, productId);
    }

    public List<Product> getAllProducts(HttpMethod GET) {
        ResponseEntity<List<Product>> response = null;
        response = restTemplate.exchange("http://your-api-base-url/api/products", GET, null, new ParameterizedTypeReference<List<Product>>() {});

        return response.getBody();
    }

    public void createProduct(Product newProduct) {
        restTemplate.postForObject("http://your-api-base-url/api/products", newProduct, Void.class);
    }

    public void updateProduct(Long productId, Product updatedProduct) {
        restTemplate.put("http://your-api-base-url/api/products/{id}", updatedProduct, productId);
    }

    public void deleteProduct(Long productId) {
        restTemplate.delete("http://your-api-base-url/api/products/{id}", productId);
    }
}

