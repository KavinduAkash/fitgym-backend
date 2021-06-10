package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.BranchEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {

    @Query("SELECT be FROM BranchEntity be WHERE be.branchName LIKE CONCAT('%', :name, '%')")
    List<BranchEntity> findBranchByNameSuggestion(@Param("name") String name);

    @Query("SELECT COUNT(be) FROM BranchEntity be WHERE be.state = :state")
    int getActiveORDeactiveBranchCount(@Param("state") ActiveAndDeActive state);
}
