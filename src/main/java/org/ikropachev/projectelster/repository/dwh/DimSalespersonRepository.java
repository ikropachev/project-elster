package org.ikropachev.projectelster.repository.dwh;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.dwh.DimSalesperson;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Salesperson Controller")
@EntityScan("org.ikropachev.projectelster.model.dwh")
public interface DimSalespersonRepository extends JpaRepository<DimSalesperson, Long> {
    @Query("SELECT s FROM DimSalesperson s ORDER BY s.id")
    List<DimSalesperson> getAll();

    @Query("SELECT s FROM DimSalesperson s WHERE s.salespersonId=:salespersonId")
    DimSalesperson findByStringId(@Param("salespersonId") String salespersonId);
}
