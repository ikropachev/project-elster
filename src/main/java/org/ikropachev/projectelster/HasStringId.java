package org.ikropachev.projectelster;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.Assert;

public interface HasStringId {
    String getId();

    void setId(String id);

    @JsonIgnore
    default boolean isNew() {
        return getId() == null;
    }

    // doesn't work for hibernate lazy proxy
    default String id() {
        Assert.notNull(getId(), "Entity must has id");
        return getId();
    }
}
