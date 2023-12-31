package org.ikropachev.projectelster.model.oltp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestBaseEntityWithLongId;

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
