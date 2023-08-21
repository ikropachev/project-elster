package org.ikropachev.projectelster.model.dwh;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.ikropachev.projectelster.model.NamedEntityWithLongId;

@Entity
@Table(name = "dim_salesperson")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DimSalesperson extends NamedEntityWithLongId {
    @Id
    @Column(name = "salesperson_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Size(min = 1, max = 255)
    @Column(name = "salesperson_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String salespersonId;

    @Size(min = 1, max = 255)
    @Column(name = "salesperson_name", nullable = false)
    @Schema(example = "salesperson_name")
    protected String name;
}
