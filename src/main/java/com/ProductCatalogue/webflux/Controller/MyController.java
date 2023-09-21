package com.ProductCatalogue.webflux.Controller;

import com.ProductCatalogue.webflux.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class MyController {
    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/fetch-data")
    public Mono<String> fetchData() {
        // Call a method from MyService to fetch data using WebClient
        return myService.fetchDataFromExternalService();
    }
}
