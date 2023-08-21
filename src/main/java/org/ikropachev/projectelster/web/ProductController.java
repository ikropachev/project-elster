package org.ikropachev.projectelster.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.dwh.DimProduct;
import org.ikropachev.projectelster.model.oltp.Product;
import org.ikropachev.projectelster.repository.dwh.DimProductRepository;
import org.ikropachev.projectelster.repository.oltp.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = ProductController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Product controller", description = "Operations for products")
public class ProductController extends AbstractController {
    static final String REST_URL = "/api/products";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DimProductRepository dimProductRepository;

    @GetMapping
    @Operation(summary = "View a list of all products from dwh")
    public List<DimProduct> getAll() {
        log.info("get all products");
        return dimProductRepository.getAll();
    }

    @GetMapping("/oltp")
    @Operation(summary = "View a list of all products from oltp")
    public List<Product> getAllFromOltp() {
        log.info("get all customers from oltp");
        return productRepository.getAll();
    }

    @PutMapping
    @Operation(summary = "Process products' dimensions")
    public void processDimensions(@Nullable @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                  @Parameter(description = "null for yesterday", example = "2023-08-21", required = false)
                                  LocalDate date) {
        if (date == null) {
            date = getYesterdayDate();
        }
        log.info("get all products updated on {}", date);
        List<Product> updatedProducts = productRepository.getAllUpdatedOnDate(date);
        log.info("fix products' dimensions");
        for (Product p : updatedProducts) {
            Long id = p.getId();
            DimProduct oldDimProduct = dimProductRepository.getById(id);
            if (oldDimProduct == null) {
                log.info("save new dim product with id {}", id);
                DimProduct newDimProduct = new DimProduct(null, id, p.getName(), date);
                dimProductRepository.save(newDimProduct);
            } else {
                log.info("update dim product with key {}", oldDimProduct.getId());
                oldDimProduct.setProductName(p.getName());
                oldDimProduct.setUpdatedDtm(date);
                dimProductRepository.save(oldDimProduct);
            }
        }
    }
}
