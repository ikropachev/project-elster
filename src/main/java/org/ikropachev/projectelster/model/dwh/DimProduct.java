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
@Table(name = "dim_product")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DimProduct extends NamedEntityWithLongId {
    @Id
    @Column(name = "product_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "product_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long productId;

    @Size(min = 1, max = 255)
    @Column(name = "product_name", nullable = false)
    @Schema(example = "product_name")
    protected String name;
}
