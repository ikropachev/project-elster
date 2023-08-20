package org.ikropachev.projectelster.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestSalesperson {
    protected String id;

    protected String name;

    //Use String in test model because LocalDate in expected response content will always like array
    protected String updatedDtm;

    public TestSalesperson(String id, String name, String updatedDtm) {
        this.id = id;
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
