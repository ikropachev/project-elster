package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import jakarta.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderInfo extends BaseEntityWithLongId {
    @NotBlank
    @Column(name = "customer_id", nullable = false)
    @Schema(example = "customer_id")
    protected String customerId;

    @NotBlank
    @Column(name = "salesperson_id", nullable = false)
    @Schema(example = "salesperson_id")
    protected String salespersonId;

    @NotNull
    @Column(name = "create_dtm", columnDefinition = "date default now()")
    @Schema(example = "create_dtm")
    protected LocalDate createDtm;

    public OrderInfo(Long id, String customerId, String salespersonId, LocalDate createDtm) {
        super(id);
        this.customerId = customerId;
        this.salespersonId = salespersonId;
        this.createDtm = createDtm;
    }
}
