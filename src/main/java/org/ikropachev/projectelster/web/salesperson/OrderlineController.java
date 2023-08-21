package org.ikropachev.projectelster.web.salesperson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.oltp.Orderline;
import org.ikropachev.projectelster.repository.oltp.OrderlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = OrderlineController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Orderline controller", description = "Operations for orderlines")
public class OrderlineController {
    static final String REST_URL = "/api/orderlines";

    @Autowired
    private OrderlineRepository orderlineRepository;

    @GetMapping
    @Operation(summary = "View a list of all orderlines")
    public List<Orderline> getAll() {
        log.info("get all orderlines");
        return orderlineRepository.getAll();
    }
}
