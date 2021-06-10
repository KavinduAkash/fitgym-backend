package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, Long> {

    @Query("SELECT p FROM PackageEntity p WHERE expDate IS NULL")
    List<PackageEntity> getAllActivePackages();

    @Query("SELECT p FROM PackageEntity p WHERE expDate IS NOT NULL")
    List<PackageEntity> getAllDeActivePackages();
}
