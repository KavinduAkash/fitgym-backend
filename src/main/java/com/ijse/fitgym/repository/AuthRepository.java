package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.AdminEntity;
import com.ijse.fitgym.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
    AuthEntity findByUserName(String name);
    AuthEntity findByAdminEntity(AdminEntity adminEntity);
}
