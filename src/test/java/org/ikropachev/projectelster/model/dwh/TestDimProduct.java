package org.ikropachev.projectelster.model.dwh;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestBaseEntityWithUpdatedDtm;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDimProduct extends TestBaseEntityWithUpdatedDtm {
    protected Long id;

    protected Long productId;

    protected String productName;

    public TestDimProduct(Long id, Long productId, String productName, String updatedDtm) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.updatedDtm = updatedDtm;
    }
}
