package org.ikropachev.projectelster.model.dwh;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestBaseEntityWithUpdatedDtm;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDimSalesperson extends TestBaseEntityWithUpdatedDtm {
    protected Long id;

    protected String salespersonId;

    protected String salespersonName;

    public TestDimSalesperson(Long id, String salespersonId, String salespersonName, String updatedDtm) {
        this.id = id;
        this.salespersonId = salespersonId;
        this.salespersonName = salespersonName;
        this.updatedDtm = updatedDtm;
    }
}
