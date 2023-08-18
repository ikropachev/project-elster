package org.ikropachev.projectelster.web.salesperson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.Salesperson;
import org.ikropachev.projectelster.repository.SalespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = SalespersonController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Salesperson controller", description = "Operations for salespersons")
public class SalespersonController {
    static final String REST_URL = "/api/salespersons";

    @Autowired
    private SalespersonRepository salespersonRepository;

    @GetMapping
    @Operation(summary = "View a list of all salespersons")
    public List<Salesperson> getAll() {
        log.info("get all salespersons");
        return salespersonRepository.getAll();
    }
}
