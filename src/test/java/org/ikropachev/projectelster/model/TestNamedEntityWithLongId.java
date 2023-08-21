package org.ikropachev.projectelster.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestNamedEntityWithLongId extends TestBaseEntityWithLongId {
    protected String name;
}
