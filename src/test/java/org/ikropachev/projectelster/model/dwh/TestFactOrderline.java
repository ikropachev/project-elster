package org.ikropachev.projectelster.model.dwh;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestBaseEntityWithLongId;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestFactOrderline extends TestBaseEntityWithLongId {
    protected Long customerKey;

    protected Long salespersonKey;

    protected Long orderId;

    protected Long productKey;

    protected Double quantity;

    protected Double price;

    public TestFactOrderline(Long id, Long customerKey, Long salespersonKey, Long orderId, Long productKey,
                             Double quantity, Double price, String updatedDtm) {
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
