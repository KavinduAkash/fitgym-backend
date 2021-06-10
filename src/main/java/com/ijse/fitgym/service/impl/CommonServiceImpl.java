package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.entity.AdminEntity;
import com.ijse.fitgym.entity.AuthEntity;
import com.ijse.fitgym.enums.UserActiveState;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.repository.AdminRepository;
import com.ijse.fitgym.repository.AuthRepository;
import com.ijse.fitgym.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

    private final AdminRepository adminRepository;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CommonServiceImpl(AdminRepository adminRepository, AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean saveIt() {
//        AdminEntity adminEntity = new AdminEntity("super1", "super1", "94767221831", "bkkasamarasingha1220@gmail.com", UserActiveState.ACTIVE);
//        AdminEntity save = adminRepository.save(adminEntity);
//        AuthEntity super1 = new AuthEntity(save, "super1",passwordEncoder.encode("super1"), UserRoles.SUPER);
//        AuthEntity save1 = authRepository.save(super1);
//        if(save1 != null) {
//            return true;
//        }
        return false;
    }
}
