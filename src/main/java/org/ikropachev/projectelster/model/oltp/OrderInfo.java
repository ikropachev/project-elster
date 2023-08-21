package org.ikropachev.projectelster.model.oltp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.ikropachev.projectelster.model.BaseEntityWithLongId;

import java.time.LocalDate;

@Entity
@Table(name = "order_info")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderInfo extends BaseEntityWithLongId {
    @Id
    @Column(name = "order_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "customer_id", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(example = "customer_id")
    protected String customerId;

    @Column(name = "salesperson_id", nullable = false)
    @Size(min = 1, max = 255)
    @Schema(example = "salesperson_id")
    protected String salespersonId;
}
