package org.ikropachev.projectelster.repository.dwh;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.dwh.FactOrderline;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Orderline Controller")
@EntityScan("org.ikropachev.projectelster.model.dwh")
public interface FactOrderlineRepository extends JpaRepository<FactOrderline, Long> {
    @Query("SELECT f FROM FactOrderline f ORDER BY f.id")
    List<FactOrderline> getAll();

    @Query("SELECT f FROM FactOrderline f WHERE f.id=:factOrderlineId")
    FactOrderline getById(@Param("factOrderlineId") Long factOrderlineId);
}
