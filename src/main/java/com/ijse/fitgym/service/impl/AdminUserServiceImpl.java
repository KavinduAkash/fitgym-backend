package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.constants.Constants;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.BranchDTO;
import com.ijse.fitgym.dto.json.request.AdminSaveRequestDTO;
import com.ijse.fitgym.dto.json.request.AdminUpdateRequestDTO;
import com.ijse.fitgym.entity.AdminEntity;
import com.ijse.fitgym.entity.AuthEntity;
import com.ijse.fitgym.entity.BranchEntity;
import com.ijse.fitgym.enums.UserActiveState;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.exception.FitGymServiceException;
import com.ijse.fitgym.repository.AdminRepository;
import com.ijse.fitgym.repository.AuthRepository;
import com.ijse.fitgym.repository.BranchRepository;
import com.ijse.fitgym.service.AdminUserService;
import com.ijse.fitgym.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
//        (propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminUserServiceImpl implements AdminUserService {
    private final AdminRepository adminRepository;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenValidator tokenValidator;
    private final BranchRepository branchRepository;

    @Autowired
    public AdminUserServiceImpl(AdminRepository adminRepository, AuthRepository authRepository, PasswordEncoder passwordEncoder, TokenValidator tokenValidator, BranchRepository branchRepository) {
        this.adminRepository = adminRepository;
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenValidator = tokenValidator;
        this.branchRepository = branchRepository;
    }

    @Override
    public boolean createNewAdmin(AdminSaveRequestDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                String firstName = dto.getFirstName();
                String lastName = dto.getLastName();
                String contact = dto.getContact();
                String email = dto.getEmail();
                long branchId = dto.getBranchId();
                String userName = dto.getUserName();
                String passsword = dto.getPasssword();
                UserRoles userRoles = dto.getUserRoles();
                Optional<BranchEntity> byId = branchRepository.findById(branchId);
                System.out.println("Branch: "+byId.get());
                if(byId.isPresent()) {
                    BranchEntity branchEntity = byId.get();
                    System.out.println("Branchx: "+branchEntity);
                    AdminEntity adminEntity = new AdminEntity();
                    adminEntity.setFirstName(firstName);
                    adminEntity.setLastName(lastName);
                    adminEntity.setContact(contact);
                    adminEntity.setEmail(email);
                    adminEntity.setState(UserActiveState.ACTIVE);
                    adminEntity.setBranchEntity(branchEntity);
                    AdminEntity adminDetailsSave = adminRepository.save(adminEntity);
                    System.out.println("AD: "+adminDetailsSave);
                    if(adminDetailsSave != null){
                        AuthEntity authEntity = new AuthEntity();
                        authEntity.setAdminEntity(adminDetailsSave);
                        authEntity.setUserName(userName);
                        authEntity.setPassword(passwordEncoder.encode(passsword));
                        authEntity.setRole(userRoles);
                        AuthEntity authSave = authRepository.save(authEntity);
                        return true;
                    }
                    throw new FitGymServiceException(Constants.SOMETHING_WENT_WRONG, "Something went wrong");
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found branch details");
            }
            throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found package details");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean updateAdmin(AdminUpdateRequestDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                String firstName = dto.getFirstName();
                String lastName = dto.getLastName();
                String contact = dto.getContact();
                String email = dto.getEmail();
                long branchId = dto.getBranchId();
                String userName = dto.getUserName();
                String passsword = dto.getPasssword();
                UserRoles userRoles = dto.getUserRoles();
                Optional<BranchEntity> byId = branchRepository.findById(branchId);
                System.out.println("Branch: "+byId.get());
                if(byId.isPresent()) {
                    BranchEntity branchEntity = byId.get();
                    Optional<AdminEntity> byId1 = adminRepository.findById(dto.getAdminId());
                    if(byId1.isPresent()) {
                        AdminEntity adminEntity = byId1.get();
                        AuthEntity byAdminId = authRepository.findByAdminEntity(adminEntity);
                        if(byAdminId != null) {
                            adminEntity.setFirstName(firstName);
                            adminEntity.setLastName(lastName);
                            adminEntity.setContact(contact);
                            adminEntity.setEmail(email);
                            adminEntity.setState(UserActiveState.ACTIVE);
                            adminEntity.setBranchEntity(branchEntity);
                            AuthEntity authEntity = byAdminId;
                            authEntity.setAdminEntity(adminEntity);
                            authEntity.setUserName(userName);
//                        authEntity.setPassword(passwordEncoder.encode(passsword));
                            authEntity.setRole(userRoles);
                            AuthEntity authSave = authRepository.save(authEntity);
                            return true;
                        }
                        throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found user details");
                    }
                    throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found user details");
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found branch details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean deactiveAdmin(long id) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                Optional<AdminEntity> byId1 = adminRepository.findById(id);
                if(byId1.isPresent()) {
                    AdminEntity adminEntity = byId1.get();
//                    AuthEntity byAdminId = authRepository.findAuthByUserId(id);
//                    if(byAdminId != null) {
                        adminEntity.setState(UserActiveState.ACTIVE);
//                        AuthEntity authEntity = byAdminId;
//                        authEntity.setAdminEntity(adminEntity);
//                        AuthEntity authSave = authRepository.save(authEntity);
                      adminRepository.save(adminEntity);
                      return true;
//                    }
//                    throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found user details");
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found user details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                List<AuthEntity> all = authRepository.findAll();
                List<AdminDTO> adminDTOS = new ArrayList<>();
                for(AuthEntity a:all) {
                    AdminEntity ad = a.getAdminEntity();
                    BranchEntity e = ad.getBranchEntity();
                    BranchDTO branchDTO = null;
                    if(e != null){
                        branchDTO = new BranchDTO(e.getBranchId(), e.getBranchName(), e.getBranchAddress(), e.getContact(), e.getLongitude(), e.getLatitude(), e.getDate(), e.getState());
                    }
                    AdminDTO admin = new AdminDTO();
                    admin.setAdminId(ad.getAdminId());
                    admin.setFirstName(ad.getFirstName());
                    admin.setLastName(ad.getLastName());
                    admin.setContact(ad.getContact());
                    admin.setEmail(ad.getEmail());
                    admin.setUserRoles(a.getRole());
                    admin.setBranchDTO(branchDTO);
                    admin.setUserName(a.getUserName());
                    adminDTOS.add(admin);
                }
                return adminDTOS;
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public List<UserRoles> getAdminRoles() {
        List<UserRoles>userRoles =  new ArrayList<>();
        userRoles.add(UserRoles.SUPER);
        userRoles.add(UserRoles.BRANCH_ADMIN);
        userRoles.add(UserRoles.INSTRUCTOR);
        return userRoles;
    }

    @Scheduled(cron = "00 05 07 * * ?")
    public void methodA() {
        System.out.println("Method A -------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

//    @Scheduled(cron = "00 24 12 * * ?")
//    public void methodB() {
//        System.out.println("Method B -------------------------------------------------------------------------------------------------------------------------------------------------------------");
//    }
}
