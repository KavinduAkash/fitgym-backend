package com.ijse.fitgym.dto.json.response;

import com.ijse.fitgym.constants.Constants;
import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.json.response.sub.AdminLoginDataResponseDTO;

public class AdminResponseDTO {
    private ResponseCode code;
    private String message;
    private AdminLoginDataResponseDTO data;

    public AdminResponseDTO() {
    }

    public AdminResponseDTO(ResponseCode code, String message, AdminLoginDataResponseDTO data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AdminLoginDataResponseDTO getData() {
        return data;
    }

    public void setData(AdminLoginDataResponseDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AdminResponseDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
