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
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends NamedEntityWithLongId {
    @Id
    @Column(name = "product_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Size(min = 1, max = 50)
    @Column(name = "product_name", nullable = false)
    @Schema(example = "name")
    protected String name;

    public Product(Long id, String name, LocalDate updatedDtm) {
        this.id = id;
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
