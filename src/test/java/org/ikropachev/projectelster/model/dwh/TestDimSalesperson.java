package org.ikropachev.projectelster.model.dwh;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestNamedEntityWithLongId;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDimSalesperson extends TestNamedEntityWithLongId {
    protected String salespersonId;

    public TestDimSalesperson(Long id, String salespersonId, String name, String updatedDtm) {
        this.id = id;
        this.salespersonId = salespersonId;
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
