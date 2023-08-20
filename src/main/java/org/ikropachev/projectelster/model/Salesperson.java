package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "salesperson")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salesperson extends NamedEntityWithStringId {
    @Id
    @Column(name = "salesperson_id", nullable = false)
    @Size(min = 1, max = 16)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String id;

    @Size(min = 1, max = 20)
    @Column(name = "salesperson_name", nullable = false)
    @Schema(example = "salesperson_name")
    protected String name;

    public Salesperson(String id, String name, LocalDate updatedDtm) {
        this.id = id;
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
