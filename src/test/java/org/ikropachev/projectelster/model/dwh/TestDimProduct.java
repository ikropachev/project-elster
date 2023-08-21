package org.ikropachev.projectelster.model.dwh;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.TestNamedEntityWithLongId;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDimProduct extends TestNamedEntityWithLongId {
    protected Long productId;

    public TestDimProduct(Long id, Long productId, String name, String updatedDtm) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
