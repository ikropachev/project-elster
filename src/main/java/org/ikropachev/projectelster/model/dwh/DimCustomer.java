package org.ikropachev.projectelster.model.dwh;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ikropachev.projectelster.model.BaseEntityWithUpdatedDtm;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "dim_customer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DimCustomer extends BaseEntityWithUpdatedDtm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_key", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected Long id;

    @Column(name = "customer_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null")
    protected String customerId;

    @Column(name = "customer_name", nullable = false)
    @Schema(example = "customer_name")
    protected String customerName;

    @Column(name = "itn", nullable = false)
    @Schema(example = "itn")
    protected String itn;

    public DimCustomer(Long id, String customerId, String customerName, String itn, LocalDate updatedDtm) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.itn = itn;
        this.updatedDtm = updatedDtm;
    }
}
