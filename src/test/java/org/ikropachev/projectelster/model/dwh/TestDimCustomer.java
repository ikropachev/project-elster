package org.ikropachev.projectelster.model.dwh;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestBaseEntityWithUpdatedDtm;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDimCustomer extends TestBaseEntityWithUpdatedDtm {
    protected Long id;

    protected String customerId;

    protected String customerName;

    protected String itn;

    public TestDimCustomer(Long id, String customerId, String customerName, String itn, String updatedDtm) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.itn = itn;
        this.updatedDtm = updatedDtm;
    }
}
