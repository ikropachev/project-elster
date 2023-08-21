package org.ikropachev.projectelster.model.oltp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.ikropachev.projectelster.model.NamedEntityWithStringId;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends NamedEntityWithStringId {
    @Id
    @Column(name = "customer_id", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String id;

    @Column(name = "cust_name", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(example = "cust_name")
    protected String name;

    @Size(min = 1, max = 255)
    @Column(name = "street", nullable = false)
    @Schema(example = "street")
    protected String street;

    @Size(min = 1, max = 255)
    @Column(name = "city", nullable = false)
    @Schema(example = "city")
    protected String city;

    @Size(min = 1, max = 255)
    @Column(name = "itn", nullable = false)
    @Schema(example = "itn")
    protected String itn;
}
