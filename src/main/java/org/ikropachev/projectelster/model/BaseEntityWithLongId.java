package org.ikropachev.projectelster.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import lombok.*;
import org.ikropachev.projectelster.HasLongId;
import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.util.Assert;

@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntityWithLongId extends BaseEntityWithUpdatedDtm implements Persistable<Long>, HasLongId {
    protected Long id;

    // doesn't work for hibernate lazy proxy
    public Long id() {
        Assert.notNull(id, "Entity must have id");
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(ProxyUtils.getUserClass(o))) {
            return false;
        }
        BaseEntityWithLongId that = (BaseEntityWithLongId) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id.toString();
    }
}
