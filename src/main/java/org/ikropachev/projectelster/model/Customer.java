package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends NamedEntityWithStringId{
    @Id
    @Column(name = "customer_id", nullable = false)
    @Size(min = 2, max = 128)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null") // https://stackoverflow.com/a/28025008/548473
    protected String id;

    @Size(min = 2, max = 128)
    @Column(name = "cust_name", nullable = false)
    @Schema(example = "cust_name")
    protected String name;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "street", nullable = false)
    @Schema(example = "street")
    protected String street;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "city", nullable = false)
    @Schema(example = "city")
    protected String city;

    @NotBlank
    @Size(min = 2, max = 20)
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
