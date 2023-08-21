package org.ikropachev.projectelster.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.ikropachev.projectelster.model.dwh.DimSalesperson;
import org.ikropachev.projectelster.model.oltp.Salesperson;
import org.ikropachev.projectelster.repository.dwh.DimSalespersonRepository;
import org.ikropachev.projectelster.repository.oltp.SalespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = SalespersonController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Salesperson controller", description = "Operations for salespersons")
public class SalespersonController extends AbstractController {
    static final String REST_URL = "/api/salespersons";

    @Autowired
    private SalespersonRepository salespersonRepository;

    @Autowired
    private DimSalespersonRepository dimSalespersonRepository;

    @GetMapping
    @Operation(summary = "View a list of all salespersons from dwh")
    public List<DimSalesperson> getAll() {
        log.info("get all salespersons");
        return dimSalespersonRepository.getAll();
    }

    @GetMapping("/oltp")
    @Operation(summary = "View a list of all salespersons from oltp")
    public List<Salesperson> getAllFromOltp() {
        log.info("get all salespersons from oltp");
        return salespersonRepository.getAll();
    }

    @PutMapping
    @Operation(summary = "Process salespersons' dimensions")
    public void processDimensions(@Nullable @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                  @Parameter(description = "null for yesterday", example = "2023-08-21", required = false)
                                  LocalDate date) {
        if (date == null) {
            date = getYesterdayDate();
        }
        log.info("get all salespersons updated on {}", date);
        List<Salesperson> updatedSalespersons = salespersonRepository.getAllUpdatedOnDate(date);
        log.info("fix salespersons' dimensions");
        for (Salesperson s : updatedSalespersons) {
            String id = s.getId();
            DimSalesperson oldDimSalesperson = dimSalespersonRepository.findByStringId(id);
            if (oldDimSalesperson == null) {
                log.info("save new dim salesperson with id {}", id);
                DimSalesperson newDimSalesperson = new DimSalesperson(null, id, s.getName(), date);
                dimSalespersonRepository.save(newDimSalesperson);
            } else {
                log.info("update dim salesperson with key {}", oldDimSalesperson.getId());
                oldDimSalesperson.setSalespersonName(s.getName());
                oldDimSalesperson.setUpdatedDtm(date);
                dimSalespersonRepository.save(oldDimSalesperson);
            }
        }
    }
}
