package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
//  https://stackoverflow.com/a/6084701/548473
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class UpdatedEntity {
    @NotNull
    @Column(name = "updated_dtm", columnDefinition = "date default now()")
    @Schema(example = "updated_dtm")
    protected LocalDate updatedDtm;
}
