package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.BranchDTO;
import com.ijse.fitgym.entity.AdminEntity;
import com.ijse.fitgym.entity.AuthEntity;
import com.ijse.fitgym.entity.BranchEntity;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.repository.AdminRepository;
import com.ijse.fitgym.repository.AuthRepository;
import com.ijse.fitgym.repository.BranchRepository;
import com.ijse.fitgym.service.CustomUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private final AdminRepository adminRepository;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final BranchRepository branchRepository;

    public CustomUserDetailsServiceImpl(AdminRepository adminRepository, AuthRepository authRepository, PasswordEncoder passwordEncoder, BranchRepository branchRepository) {
        this.adminRepository = adminRepository;
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.branchRepository = branchRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthEntity byUserName = authRepository.findByUserName(username);
        if(byUserName != null) {
            System.out.println("HERE 1");
            return new User(username, byUserName.getPassword(),new ArrayList<>());
        }
        return null;
    }

    @Override
    public AdminDTO getAdminByUserName(String userName) {
        System.out.println("ok4");
        AuthEntity byUserName = authRepository.findByUserName(userName);
        System.out.println("ok5");
        if(byUserName != null) {
            System.out.println("ok6");
            UserRoles role = byUserName.getRole();
            System.out.println("ok7");
            AdminEntity adminEntity = byUserName.getAdminEntity();
            System.out.println("ok8");
            BranchEntity branchEntity = adminEntity.getBranchEntity();
            System.out.println("ok9");
            BranchDTO branchDTO = null;
            if(branchEntity != null) {
                branchDTO = new BranchDTO(branchEntity.getBranchId(), branchEntity.getBranchName(), branchEntity.getBranchAddress(), branchEntity.getContact(), branchEntity.getLongitude(), branchEntity.getLatitude(), branchEntity.getDate(), branchEntity.getState());
            }
            System.out.println("ok10 "+branchEntity.getState());
            return new AdminDTO(adminEntity.getAdminId(), adminEntity.getFirstName(), adminEntity.getLastName(), adminEntity.getContact(), adminEntity.getEmail(), role, branchDTO, byUserName.getUserName());
        }
        return null;
    }

    @Override
    public AdminDTO findAdmin(String userName) {
        AuthEntity byUserName = authRepository.findByUserName(userName);
        if(byUserName != null) {
            UserRoles role = byUserName.getRole();
            AdminEntity adminEntity = byUserName.getAdminEntity();
            return new AdminDTO(adminEntity.getAdminId(), adminEntity.getFirstName(), adminEntity.getLastName(), adminEntity.getContact(), adminEntity.getEmail(), role);
        }
        return null;
    }

}
