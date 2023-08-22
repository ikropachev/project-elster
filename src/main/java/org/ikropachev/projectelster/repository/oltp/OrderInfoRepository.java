package org.ikropachev.projectelster.repository.oltp;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.dwh.DimProduct;
import org.ikropachev.projectelster.model.oltp.Customer;
import org.ikropachev.projectelster.model.oltp.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "OrderInfo Controller")
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
    //Use for tests
    @Query("SELECT o FROM OrderInfo o ORDER BY o.id")
    List<OrderInfo> getAll();

    @Query("SELECT o FROM OrderInfo o WHERE o.id=:orderId")
    OrderInfo getById(@Param("orderId") Long orderId);

    @Query("SELECT o FROM OrderInfo o WHERE o.updatedDtm=:date  ORDER BY o.id")
    List<OrderInfo> getAllUpdatedOnDate(@Param("date") LocalDate date);
}
