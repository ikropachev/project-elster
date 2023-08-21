package org.ikropachev.projectelster.model.dwh;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.BaseEntityWithUpdatedDtm;

import java.time.LocalDate;

@Entity
@Table(name = "dim_salesperson")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DimSalesperson extends BaseEntityWithUpdatedDtm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesperson_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "salesperson_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String salespersonId;

    @Column(name = "salesperson_name", nullable = false)
    @Schema(example = "salesperson_name")
    protected String salespersonName;

    public DimSalesperson(Long id, String salespersonId, String salespersonName, LocalDate updatedDtm) {
        this.id = id;
        this.salespersonId = salespersonId;
        this.salespersonName = salespersonName;
        this.updatedDtm = updatedDtm;
    }
}
