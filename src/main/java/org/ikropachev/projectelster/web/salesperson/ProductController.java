package org.ikropachev.projectelster.web.salesperson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.Customer;
import org.ikropachev.projectelster.model.Product;
import org.ikropachev.projectelster.repository.CustomerRepository;
import org.ikropachev.projectelster.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ProductController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Product controller", description = "Operations for products")
public class ProductController {
    static final String REST_URL = "/api/products";

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @Operation(summary = "View a list of all products")
    public List<Product> getAll() {
        log.info("get all products");
        return productRepository.getAll();
    }
}
