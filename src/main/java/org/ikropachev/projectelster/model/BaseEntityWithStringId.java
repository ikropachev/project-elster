package org.ikropachev.projectelster.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.ikropachev.projectelster.HasStringId;
import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.util.Assert;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

//  https://stackoverflow.com/a/6084701/548473
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntityWithStringId extends UpdatedEntity implements Persistable<String>, HasStringId {
    protected String id;

    // doesn't work for hibernate lazy proxy
    public String id() {
        Assert.notNull(id, "Entity must have id");
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return id == null;
    }

    //    https://stackoverflow.com/questions/1638723
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(ProxyUtils.getUserClass(o))) {
            return false;
        }
        BaseEntityWithStringId that = (BaseEntityWithStringId) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }
}
