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
@Table(name = "dim_customer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DimCustomer extends NamedEntityWithLongId {
    @Id
    @Column(name = "customer_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Size(min = 1, max = 255)
    @Column(name = "customer_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String customerId;

    @Column(name = "customer_name", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(example = "customer_name")
    protected String name;

    @Size(min = 1, max = 255)
    @Column(name = "itn", nullable = false)
    @Schema(example = "itn")
    protected String itn;
}
