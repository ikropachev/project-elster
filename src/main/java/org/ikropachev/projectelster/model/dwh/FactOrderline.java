package org.ikropachev.projectelster.model.dwh;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.ikropachev.projectelster.model.BaseEntityWithLongId;

import java.time.LocalDate;

@Entity
@Table(name = "fact_orderline")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FactOrderline extends BaseEntityWithLongId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderline_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "customer_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long customerKey;

    @Column(name = "salesperson_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long salespersonKey;

    @Column(name = "order_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long orderId;

    @Column(name = "product_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long productKey;

    @Column(name = "quantity", nullable = false)
    @Schema(example = "quantity")
    protected Double quantity;

    @Column(name = "price", nullable = false)
    @Schema(example = "price")
    protected Double price;

    public FactOrderline(Long id, Long customerKey, Long salespersonKey, Long orderId, Long productKey, Double quantity, Double price, LocalDate updatedDtm) {
        this.id = id;
        this.customerKey = customerKey;
        this.salespersonKey = salespersonKey;
        this.orderId = orderId;
        this.productKey = productKey;
        this.quantity = quantity;
        this.price = price;
        this.updatedDtm = updatedDtm;
    }
}
