package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    @Query("SELECT m FROM MemberEntity m WHERE :contactType LIKE :contact")
    List<MemberEntity> searchMember(@Param("contact") String contact, @Param("contactType") String type);

}
