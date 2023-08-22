package org.ikropachev.projectelster.repository.oltp;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ikropachev.projectelster.model.oltp.OrderInfo;
import org.ikropachev.projectelster.model.oltp.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Tag(name = "Orderline Controller")
public interface OrderlineRepository extends JpaRepository<Orderline, Long> {
    //Use for tests
    @Query("SELECT o FROM Orderline o ORDER BY o.id")
    List<Orderline> getAll();

    @Query("SELECT o FROM Orderline o WHERE o.updatedDtm=:date  ORDER BY o.id")
    List<Orderline> getAllUpdatedOnDate(@Param("date") LocalDate date);
}
