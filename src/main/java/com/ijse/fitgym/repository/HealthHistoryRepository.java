package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.HealthHistoryEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthHistoryRepository extends JpaRepository<HealthHistoryEntity, Long> {
    @Query("SELECT he FROM HealthHistoryEntity he WHERE he.state = :state")
    List<HealthHistoryEntity> getActiveORDeactiveHealthHistory(@Param("state") ActiveAndDeActive state);
}
