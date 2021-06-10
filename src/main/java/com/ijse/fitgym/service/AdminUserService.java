package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.json.request.AdminSaveRequestDTO;
import com.ijse.fitgym.dto.json.request.AdminUpdateRequestDTO;
import com.ijse.fitgym.enums.UserRoles;

import java.util.List;

public interface AdminUserService {
    boolean createNewAdmin(AdminSaveRequestDTO adminSaveRequestDTO);
    boolean updateAdmin(AdminUpdateRequestDTO dto);
    boolean deactiveAdmin(long id);
    List<AdminDTO> getAllAdmin();
    List<UserRoles> getAdminRoles();
}
