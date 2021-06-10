package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
}
