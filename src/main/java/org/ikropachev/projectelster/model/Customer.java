package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends NamedEntityWithStringId {
    @Id
    @Column(name = "customer_id", nullable = false)
    @Size(min = 1, max = 16)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String id;

    @Column(name = "cust_name", nullable = false)
    @Size(min = 1, max = 20)
    @Schema(example = "cust_name")
    protected String name;

    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "street", nullable = false)
    @Schema(example = "street")
    protected String street;

    @NotBlank
    @Size(min = 1, max = 30)
    @Column(name = "city", nullable = false)
    @Schema(example = "city")
    protected String city;

    @NotBlank
    @Size(min = 1, max = 20)
    @Column(name = "itn", nullable = false)
    @Schema(example = "itn")
    protected String itn;

    public Customer(String id, String name, String street, String city, String itn, LocalDate updatedDtm) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.itn = itn;
        this.updatedDtm = updatedDtm;
    }
}
