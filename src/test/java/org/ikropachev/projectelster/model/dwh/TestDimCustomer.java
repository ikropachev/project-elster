package org.ikropachev.projectelster.model.dwh;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestNamedEntityWithLongId;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDimCustomer extends TestNamedEntityWithLongId {
    protected String customerId;

    protected String itn;

    public TestDimCustomer(Long id, String customerId, String name, String itn, String updatedDtm) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.itn = itn;
        this.updatedDtm = updatedDtm;
    }
}
