package org.ikropachev.projectelster.model.oltp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.ikropachev.projectelster.model.NamedEntityWithLongId;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends NamedEntityWithLongId {
    @Id
    @Column(name = "product_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "product_name", nullable = false)
    @Schema(example = "name")
    protected String name;
}
