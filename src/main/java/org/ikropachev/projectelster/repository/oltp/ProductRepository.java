package org.ikropachev.projectelster.repository.oltp;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.oltp.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Product Controller")
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Use for tests
    @Query("SELECT p FROM Product p ORDER BY p.id")
    List<Product> getAll();

    @Query("SELECT p FROM Product p WHERE p.updatedDtm=:date  ORDER BY p.id")
    List<Product> getAllUpdatedOnDate(@Param("date") LocalDate date);
}
