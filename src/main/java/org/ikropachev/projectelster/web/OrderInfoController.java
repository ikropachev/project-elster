package org.ikropachev.projectelster.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.oltp.OrderInfo;
import org.ikropachev.projectelster.repository.oltp.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = OrderInfoController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Order Info controller", description = "Operations for orders' info")
public class OrderInfoController {
    static final String REST_URL = "/api/ordersinfo";

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @GetMapping("/oltp")
    @Operation(summary = "View a list of all orders' info from oltp")
    public List<OrderInfo> getAllFromOltp() {
        log.info("get all orders' info from oltp");
        return orderInfoRepository.getAll();
    }
}
