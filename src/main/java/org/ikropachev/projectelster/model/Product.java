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

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends NamedEntityWithLongId {
    @Id
    @Column(name = "product_id", nullable = false)
    @Size(min = 2, max = 128)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null") // https://stackoverflow.com/a/28025008/548473
    protected Long id;

    @Size(min = 2, max = 128)
    @jakarta.persistence.Column(name = "product_name", nullable = false)
    @Schema(example = "name")
    protected String name;

    @NotBlank
    @Column(name = "supplier_id", nullable = false)
    @Schema(example = "supplier_id")
    protected Integer supplierId;

    @NotBlank
    @Column(name = "producttype_id", nullable = false)
    @Schema(example = "producttype_id")
    protected Integer producttypeId;

    public Product(Long id, String name, Integer supplierId, Integer productTypeId, LocalDate updatedDtm) {
        this.id = id;
        this.name = name;
        this.supplierId = supplierId;
        this.producttypeId = productTypeId;
        this.updatedDtm = updatedDtm;
    }
}
