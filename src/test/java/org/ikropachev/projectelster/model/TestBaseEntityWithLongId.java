package org.ikropachev.projectelster.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestBaseEntityWithLongId extends TestBaseEntityWithUpdatedDtm {
    protected Long id;
}
