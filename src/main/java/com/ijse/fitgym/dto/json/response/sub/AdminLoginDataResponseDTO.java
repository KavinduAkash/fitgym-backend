package com.ijse.fitgym.dto.json.response.sub;

import com.ijse.fitgym.dto.AdminDTO;

public class AdminLoginDataResponseDTO {
    private AdminDTO adminDTO;
    private String token;

    public AdminLoginDataResponseDTO() {
    }

    public AdminLoginDataResponseDTO(AdminDTO adminDTO, String token) {
        this.adminDTO = adminDTO;
        this.token = token;
    }

    public AdminDTO getAdminDTO() {
        return adminDTO;
    }

    public void setAdminDTO(AdminDTO adminDTO) {
        this.adminDTO = adminDTO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AdminLoginDataResponseDTO{" +
                "adminDTO=" + adminDTO +
                ", token='" + token + '\'' +
                '}';
    }
}
