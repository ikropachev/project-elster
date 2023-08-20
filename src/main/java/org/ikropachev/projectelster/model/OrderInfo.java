package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "order_info")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderInfo extends BaseEntityWithLongId {
    @Id
    @Column(name = "order_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @NotBlank
    @Column(name = "customer_id", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(example = "customer_id")
    protected String customerId;

    @NotBlank
    @Column(name = "salesperson_id", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(example = "salesperson_id")
    protected String salespersonId;

    public OrderInfo(Long id, String customerId, String salespersonId, LocalDate updatedDtm) {
        super(id);
        this.customerId = customerId;
        this.salespersonId = salespersonId;
        this.updatedDtm = updatedDtm;
    }
}
