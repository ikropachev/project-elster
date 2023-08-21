package org.ikropachev.projectelster.model.oltp;

import lombok.*;
import org.ikropachev.projectelster.model.TestNamedEntityWithStringId;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestCustomer extends TestNamedEntityWithStringId {
    protected String street;

    protected String city;

    protected String itn;

    public TestCustomer(String id, String name, String street, String city, String itn, String updatedDtm) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.itn = itn;
        this.updatedDtm = updatedDtm;
    }
}
