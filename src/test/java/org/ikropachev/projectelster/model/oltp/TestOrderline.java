package org.ikropachev.projectelster.model.oltp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestBaseEntityWithLongId;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestOrderline extends TestBaseEntityWithLongId {
    protected Integer orderId;

    protected Integer productId;

    protected Double quantity;

    protected Double price;

    public TestOrderline(Long id, Integer orderId, Integer productId, Double quantity, Double price, String updatedDtm) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.updatedDtm = updatedDtm;
    }
}
