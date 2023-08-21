package org.ikropachev.projectelster.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.dwh.DimCustomer;
import org.ikropachev.projectelster.model.oltp.Customer;
import org.ikropachev.projectelster.repository.dwh.DimCustomerRepository;
import org.ikropachev.projectelster.repository.oltp.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = CustomerController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Customer controller", description = "Operations for customers")
public class CustomerController {
    static final String REST_URL = "/api/customers";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DimCustomerRepository dimCustomerRepository;

    @GetMapping
    @Operation(summary = "View a list of all customers from dwh")
    public List<DimCustomer> getAll() {
        log.info("get all customers from dwh");
        return dimCustomerRepository.getAll();
    }

    @PutMapping
    @Operation(summary = "Process customers' dimensions")
    public void processDimensions(@Nullable @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                 @Parameter(description = "null for yesterday", example = "yyyy-MM-dd", required = false)
                                                 LocalDate date) {
        if (date == null) {
            date = LocalDate.now().minusDays(1);
            log.info("set date {}", date);
        }
        log.info("get all customers updated on {}", date);
        List<Customer> updatedCustomers = customerRepository.getAllUpdatedOnDate(date);
        log.info("fix customers' dimensions");
        for (Customer c : updatedCustomers) {
            DimCustomer oldDimCustomer = dimCustomerRepository.findByStringId(c.getId());
            if (oldDimCustomer == null) {
                log.info("save new dim customer with id {}", c.getId());
                DimCustomer newDimCustomer = new DimCustomer(null, c.getId(), c.getName(), c.getItn(), LocalDate.now());
                dimCustomerRepository.save(newDimCustomer);
            } else {
                log.info("update dim customer with key {}", oldDimCustomer.getId());
                oldDimCustomer.setCustomerName(c.getName());
                oldDimCustomer.setItn(c.getItn());
                oldDimCustomer.setUpdatedDtm(LocalDate.now());
                dimCustomerRepository.save(oldDimCustomer);
            }
        }
    }

    @GetMapping("/")
    @Operation(summary = "View a list of all customers updated yesterday")
    public List<Customer> getAllUpdatedYesterday(@Nullable @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @Parameter(description = "null for yesterday", example = "yyyy-MM-dd", required = false)
                                   LocalDate date) {
        log.info("get all customers by updated date {}", date);
        if (date == null) {
            date = LocalDate.now().minusDays(1);
            log.info("set date {}", date);
        }
        return customerRepository.getAllUpdatedOnDate(date);
    }
}
