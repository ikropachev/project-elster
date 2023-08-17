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

@Entity
@Table(name = "orderline")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orderline extends BaseEntityWithLongId {
    @NotBlank
    @Column(name = "order_id", nullable = false)
    @Schema(example = "order_id")
    protected Integer orderId;

    @NotBlank
    @Column(name = "product_id", nullable = false)
    @Schema(example = "product_id")
    protected Integer productId;

    @NotBlank
    @Column(name = "quantity", nullable = false)
    @Schema(example = "quantity")
    protected Double quantity;

    @NotBlank
    @Column(name = "price", nullable = false)
    @Schema(example = "price")
    protected Double price;

    public Orderline(Long id, Integer orderId, Integer productId, Double quantity, Double price) {
        super(id);
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
