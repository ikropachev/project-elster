package org.ikropachev.projectelster.model.oltp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.ikropachev.projectelster.model.BaseEntityWithLongId;

import java.time.LocalDate;

@Entity
@Table(name = "orderline")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Orderline extends BaseEntityWithLongId {
    @Id
    @Column(name = "orderline_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "order_id", nullable = false)
    @Schema(example = "order_id")
    protected Integer orderId;

    @Column(name = "product_id", nullable = false)
    @Schema(example = "product_id")
    protected Integer productId;

    @Column(name = "quantity", nullable = false)
    @Schema(example = "quantity")
    protected Double quantity;

    @Column(name = "price", nullable = false)
    @Schema(example = "price")
    protected Double price;
}
