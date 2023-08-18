package org.ikropachev.projectelster.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.Customer;
import org.ikropachev.projectelster.model.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Customer Controller")
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("SELECT c FROM Customer c ORDER BY c.id")
    List<Customer> getAll();
}
