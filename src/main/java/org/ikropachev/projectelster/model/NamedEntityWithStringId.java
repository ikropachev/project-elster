package org.ikropachev.projectelster.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class NamedEntityWithStringId extends BaseEntityWithStringId {

    @NotBlank
    @Size(min = 2, max = 128)
    @Column(name = "name", nullable = false)
    @Schema(example = "name")
    protected String name;

    protected NamedEntityWithStringId(String id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + name + ']';
    }
}
