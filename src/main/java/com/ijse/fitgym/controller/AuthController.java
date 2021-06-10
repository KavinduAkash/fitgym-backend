package com.ijse.fitgym.controller;

import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.json.request.UserDTO;
//import com.ijse.fitgym.dto.json.response.AdminResponseDTO;
import com.ijse.fitgym.dto.json.response.ResponseDTO;
import com.ijse.fitgym.dto.json.response.sub.AdminLoginDataResponseDTO;
import com.ijse.fitgym.entity.AdminEntity;
import com.ijse.fitgym.entity.AuthEntity;
import com.ijse.fitgym.enums.UserActiveState;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.service.CommonService;
import com.ijse.fitgym.service.CustomUserDetailsService;
import com.ijse.fitgym.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CommonService commonService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/xx")
    public String welcome() {
        return "Welcome to javatechie !!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity generateToken(@RequestBody UserDTO authRequest) throws Exception {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword());
            authenticationManager.authenticate(
                    authenticationToken
            );
            String token = jwtUtil.generateToken(authRequest.getUserName());
            System.out.println("ok1");
            AdminDTO adminByUserName = customUserDetailsService.getAdminByUserName(authRequest.getUserName());
            System.out.println("ok2");
            AdminLoginDataResponseDTO adminLoginDataResponseDTO = new AdminLoginDataResponseDTO(adminByUserName, token);
            System.out.println("ok3");
            return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Admin details found successfully", adminLoginDataResponseDTO), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new ResponseDTO(ResponseCode.NOT_EXISTS, false, "Invalid user_name or password"), HttpStatus.OK);
        }

    }

    @PostMapping(path = "/super")
    public boolean saveIt() {
        boolean b = commonService.saveIt();
        return b;
    }
}
