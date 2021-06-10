package com.ijse.fitgym.controller;

import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.json.request.AdminSaveRequestDTO;
import com.ijse.fitgym.dto.json.response.ResponseDTO;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class AdminController {

    private final AdminUserService adminUserService;

    @Autowired
    public AdminController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity saveNewAdmin(@RequestBody AdminSaveRequestDTO dto) {

        boolean newAdmin = adminUserService.createNewAdmin(dto);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, newAdmin, "Admin saved successfully"), HttpStatus.OK);

    }

    @GetMapping(path = "/get")
    public ResponseEntity getAllAdmins() {
        List<AdminDTO> allAdmin = adminUserService.getAllAdmin();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Get all admins successfully", allAdmin), HttpStatus.OK);
    }

    @GetMapping(path = "/roles")
    public ResponseEntity getAdminRoles() {
        List<UserRoles> adminRoles = adminUserService.getAdminRoles();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Get admin roles successfully", adminRoles), HttpStatus.OK);
    }

}
