package org.ikropachev.projectelster.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.ikropachev.projectelster.HasStringId;
import org.springframework.data.util.ProxyUtils;
import org.springframework.util.Assert;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "salesperson")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salesperson extends NamedEntityWithStringId {
    @Id
    @Column(name = "salesperson_id", nullable = false)
    @Size(min = 2, max = 128)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "null") // https://stackoverflow.com/a/28025008/548473
    protected String id;

    @Size(min = 2, max = 128)
    @Column(name = "salesperson_name", nullable = false)
    @Schema(example = "salesperson_name")
    protected String name;

    public Salesperson(String id, String name, LocalDate updatedDtm) {
        this.id = id;
        this.name = name;
        this.updatedDtm = updatedDtm;
    }
}
