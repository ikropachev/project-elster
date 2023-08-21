package org.ikropachev.projectelster.model.oltp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.ikropachev.projectelster.model.NamedEntityWithStringId;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends NamedEntityWithStringId {
    @Id
    @Column(name = "customer_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String id;

    @Column(name = "cust_name", nullable = false)
    @Schema(example = "cust_name")
    protected String name;

    @Column(name = "street", nullable = false)
    @Schema(example = "street")
    protected String street;

    @Column(name = "city", nullable = false)
    @Schema(example = "city")
    protected String city;

    @Column(name = "itn", nullable = false)
    @Schema(example = "itn")
    protected String itn;
}
