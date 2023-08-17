package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
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
public class Customer extends BaseEntityWithStringId{
    @Size(min = 2, max = 128)
    @jakarta.persistence.Column(name = "name", nullable = false)
    @Schema(example = "name")
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

    @NotNull
    @Column(name = "updated_dtm", columnDefinition = "date default now()")
    @Schema(example = "updated_dtm")
    protected LocalDate updatedDtm;

    public Customer(String id, String name, String street, String city, String itn, LocalDate updatedDtm) {
        super(id);
        this.name = name;
        this.street = street;
        this.city = city;
        this.itn = itn;
        this.updatedDtm = updatedDtm;
    }
}
