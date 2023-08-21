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
@Table(name = "dim_product")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DimProduct extends BaseEntityWithUpdatedDtm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "product_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long productId;

    @Column(name = "product_name", nullable = false)
    @Schema(example = "product_name")
    protected String productName;

    public DimProduct(Long id, Long productId, String productName, LocalDate updatedDtm) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.updatedDtm = updatedDtm;
    }
}
