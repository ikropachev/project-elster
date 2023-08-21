package org.ikropachev.projectelster.repository.dwh;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.dwh.DimCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Customer Controller")
public interface DimCustomerRepository extends JpaRepository<DimCustomer, Long> {
    @Query("SELECT c FROM DimCustomer c ORDER BY c.id")
    List<DimCustomer> getAll();

    @Query("SELECT c FROM DimCustomer c WHERE c.customerId=:customerId")
    DimCustomer findByStringId(@Param("customerId") String customerId);
}
