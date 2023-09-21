package com.ProductCatalogue.webflux.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
    @NoArgsConstructor
    @Table(name = "products")
    public class ProductEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name = "productName")
        private String productName;

        @Column(name = "description")
        private String description;

        @Column(name = "price")
        private double price;

        public ProductEntity(String productName, String description, double price) {
            this.productName = productName;
            this.description = description;
            this.price = price;
        }
    }

