package org.ikropachev.projectelster.repository.dwh;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.dwh.FactOrderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Orderline Controller")
public interface FactOrderlineRepository extends JpaRepository<FactOrderline, Long> {
    @Query("SELECT o FROM FactOrderline o ORDER BY o.id")
    List<FactOrderline> getAll();
}
