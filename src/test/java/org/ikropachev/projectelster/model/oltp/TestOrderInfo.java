package org.ikropachev.projectelster.model.oltp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestBaseEntityWithLongId;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestOrderInfo extends TestBaseEntityWithLongId {
    protected String customerId;

    protected String salespersonId;

    public TestOrderInfo(Long id, String customerId, String salespersonId, String updatedDtm) {
        this.id = id;
        this.customerId = customerId;
        this.salespersonId = salespersonId;
        this.updatedDtm = updatedDtm;
    }
}
