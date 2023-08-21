package org.ikropachev.projectelster.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestProduct extends TestNamedEntityWithLongId {
    public TestProduct(Long id, String name, String updatedDtm) {
        this.id = id;
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
