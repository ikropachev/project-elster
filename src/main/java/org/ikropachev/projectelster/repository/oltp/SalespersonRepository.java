package org.ikropachev.projectelster.repository.oltp;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.oltp.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Salesperson Controller")
public interface SalespersonRepository extends JpaRepository<Salesperson, String> {
    //Use for tests
    @Query("SELECT s FROM Salesperson s ORDER BY s.id")
    List<Salesperson> getAll();

    @Query("SELECT s FROM Salesperson s WHERE s.updatedDtm=:date  ORDER BY s.id")
    List<Salesperson> getAllUpdatedOnDate(@Param("date") LocalDate date);
}
