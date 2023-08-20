package org.ikropachev.projectelster.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "OrderInfo Controller")
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
    @Query("SELECT o FROM OrderInfo o ORDER BY o.id")
    List<OrderInfo> getAll();
}
