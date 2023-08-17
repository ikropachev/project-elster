package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import jakarta.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "salesperson")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salesperson extends BaseEntityWithStringId{
    @Size(min = 2, max = 128)
    @jakarta.persistence.Column(name = "name", nullable = false)
    @Schema(example = "name")
    protected String name;

    @NotNull
    @Column(name = "updated_dtm", columnDefinition = "date default now()")
    @Schema(example = "updated_dtm")
    protected LocalDate updatedDtm;

    public Salesperson(String id, String name, LocalDate updatedDtm) {
        super(id);
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
