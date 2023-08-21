package org.ikropachev.projectelster.web.salesperson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.oltp.Customer;
import org.ikropachev.projectelster.repository.oltp.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = CustomerController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Customer controller", description = "Operations for customers")
public class CustomerController {
    static final String REST_URL = "/api/customers";

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    @Operation(summary = "View a list of all customers")
    public List<Customer> getAll() {
        log.info("get all customers");
        return customerRepository.getAll();
    }
}
