package org.ikropachev.projectelster.repository;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.ikropachev.projectelster.model.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Salesperson Controller")
public interface SalespersonRepository extends JpaRepository<Salesperson, String> {
    @Query("SELECT sp FROM Salesperson sp ORDER BY sp.id")
    List<Salesperson> getAll();
}
