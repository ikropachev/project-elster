package org.ikropachev.projectelster.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.dwh.DimCustomer;
import org.ikropachev.projectelster.model.dwh.DimProduct;
import org.ikropachev.projectelster.model.dwh.DimSalesperson;
import org.ikropachev.projectelster.model.dwh.FactOrderline;
import org.ikropachev.projectelster.model.oltp.OrderInfo;
import org.ikropachev.projectelster.model.oltp.Orderline;
import org.ikropachev.projectelster.repository.dwh.DimCustomerRepository;
import org.ikropachev.projectelster.repository.dwh.DimProductRepository;
import org.ikropachev.projectelster.repository.dwh.DimSalespersonRepository;
import org.ikropachev.projectelster.repository.dwh.FactOrderlineRepository;
import org.ikropachev.projectelster.repository.oltp.OrderInfoRepository;
import org.ikropachev.projectelster.repository.oltp.OrderlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = OrderlineController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Orderline controller", description = "Operations for orderlines")
public class OrderlineController extends AbstractController {
    static final String REST_URL = "/api/orderlines";

    @Autowired
    private OrderlineRepository orderlineRepository;

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private FactOrderlineRepository factOrderlineRepository;

    @Autowired
    private DimCustomerRepository dimCustomerRepository;

    @Autowired
    private DimProductRepository dimProductRepository;

    @Autowired
    private DimSalespersonRepository dimSalespersonRepository;

    @GetMapping
    @Operation(summary = "View a list of all orderlines from dwh")
    public List<FactOrderline> getAll() {
        log.info("get all orderlines from dwh");
        return factOrderlineRepository.getAll();
    }

    @GetMapping("/oltp")
    @Operation(summary = "View a list of all orderlines from oltp")
    public List<Orderline> getAllFromOltp() {
        log.info("get all orderlines from oltp");
        return orderlineRepository.getAll();
    }

    @PutMapping
    @Operation(summary = "Process fact orderlines")
    public void processFactOrderline(@Nullable @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                     @Parameter(description = "null for yesterday", example = "2023-08-21", required = false)
                                     LocalDate date) {
        if (date == null) {
            date = getYesterdayDate();
        }
        log.info("get all orderlines updated on {}", date);
        List<Orderline> updatedOrderlines = orderlineRepository.getAllUpdatedOnDate(date);
        log.info("fix orderlines");
        for (Orderline o : updatedOrderlines) {
            Long id = o.getId();
            FactOrderline oldFactOrderline = factOrderlineRepository.getById(id);
            if (oldFactOrderline == null) {
                OrderInfo orderInfo = orderInfoRepository.getById(o.getOrderId());
                DimCustomer dimCustomer = dimCustomerRepository.findByStringId(orderInfo.getCustomerId());
                DimSalesperson dimSalesperson = dimSalespersonRepository.findByStringId(orderInfo.getSalespersonId());
                DimProduct dimProduct = dimProductRepository.getById(o.getProductId());
                log.info("save new orderline with id {}", id);
                FactOrderline newFactOrderline = new FactOrderline(id, dimCustomer.getId(), dimSalesperson.getId(),
                        o.getOrderId(), dimProduct.getId(), o.getQuantity(), o.getPrice(), o.getUpdatedDtm());
                factOrderlineRepository.save(newFactOrderline);
            }
        }
    }
}
