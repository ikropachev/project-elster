package org.ikropachev.projectelster.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestBaseEntityWithUpdatedDtm {
    //Use String in test model because LocalDate in expected response content will always like array
    protected String updatedDtm;
}
