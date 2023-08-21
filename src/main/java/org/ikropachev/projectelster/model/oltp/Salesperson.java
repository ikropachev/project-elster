package org.ikropachev.projectelster.model.oltp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.ikropachev.projectelster.model.NamedEntityWithStringId;

@Entity
@Table(name = "salesperson")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Salesperson extends NamedEntityWithStringId {
    @Id
    @Column(name = "salesperson_id", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String id;

    @Size(min = 1, max = 255)
    @Column(name = "salesperson_name", nullable = false)
    @Schema(example = "salesperson_name")
    protected String name;
}
