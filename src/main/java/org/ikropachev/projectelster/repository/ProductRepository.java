package org.ikropachev.projectelster.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.Customer;
import org.ikropachev.projectelster.model.OrderInfo;
import org.ikropachev.projectelster.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Product Controller")
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p ORDER BY p.id")
    List<Product> getAll();
}
