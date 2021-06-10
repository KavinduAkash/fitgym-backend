package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.json.request.AdminSaveRequestDTO;
import com.ijse.fitgym.entity.AdminEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {
    AdminDTO getAdminByUserName(String userName);
    AdminDTO findAdmin(String userName);
}
