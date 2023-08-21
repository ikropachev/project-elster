package org.ikropachev.projectelster.repository.oltp;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.oltp.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Customer Controller")
public interface CustomerRepository extends JpaRepository<Customer, String> {
    //Use for tests
    @Query("SELECT c FROM Customer c ORDER BY c.id")
    List<Customer> getAll();

    @Query("SELECT c FROM Customer c WHERE c.updatedDtm=:date  ORDER BY c.id")
    List<Customer> getAllUpdatedOnDate(@Param("date") LocalDate date);
}
