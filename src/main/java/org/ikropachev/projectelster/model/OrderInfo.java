package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
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
    @Id
    @Column(name = "order_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null") // https://stackoverflow.com/a/28025008/548473
    protected Long id;

    @NotBlank
    @Column(name = "customer_id", nullable = false)
    @Schema(example = "customer_id")
    protected String customerId;

    @NotBlank
    @Column(name = "salesperson_id", nullable = false)
    @Schema(example = "salesperson_id")
    protected String salespersonId;

    public OrderInfo(Long id, String customerId, String salespersonId, LocalDate updatedDtm) {
        super(id);
        this.customerId = customerId;
        this.salespersonId = salespersonId;
        this.updatedDtm = updatedDtm;
    }
}
