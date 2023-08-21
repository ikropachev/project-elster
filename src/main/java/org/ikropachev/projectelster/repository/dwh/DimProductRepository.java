package org.ikropachev.projectelster.repository.dwh;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.dwh.DimProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Product Controller")
public interface DimProductRepository extends JpaRepository<DimProduct, Long> {
    @Query("SELECT p FROM DimProduct p ORDER BY p.id")
    List<DimProduct> getAll();

    @Query("SELECT p FROM DimProduct p WHERE p.productId=:productId")
    DimProduct getById(@Param("productId") Long productId);
}
