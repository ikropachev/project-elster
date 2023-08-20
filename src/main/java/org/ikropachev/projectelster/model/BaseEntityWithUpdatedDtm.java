package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@MappedSuperclass
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntityWithUpdatedDtm {
    @NotNull
    @Column(name = "updated_dtm")
    @Schema(example = "updated_dtm")
    protected LocalDate updatedDtm;
}
