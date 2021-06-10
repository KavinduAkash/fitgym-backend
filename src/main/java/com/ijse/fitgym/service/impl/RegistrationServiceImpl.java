package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.MemberDTO;
import com.ijse.fitgym.dto.json.request.MemberRegistrationRequestDTO;
import com.ijse.fitgym.dto.json.request.RegisrationSaveRequestDTO;
import com.ijse.fitgym.dto.json.request.sub.HealthQUAnswerMemberRegDTO;
import com.ijse.fitgym.entity.*;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import com.ijse.fitgym.enums.MemberRoles;
import com.ijse.fitgym.repository.*;
import com.ijse.fitgym.service.RegistrationService;
import com.ijse.fitgym.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RegistrationServiceImpl implements RegistrationService {

    private final BranchRepository branchRepository;
    private final TokenValidator tokenValidator;
    private final MemberRepository memberRepository;
    private final PackageRepository packageRepository;
    private final AdminRepository adminRepository;
    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(BranchRepository branchRepository, TokenValidator tokenValidator, MemberRepository memberRepository, PackageRepository packageRepository, AdminRepository adminRepository, RegistrationRepository registrationRepository) {
        this.branchRepository = branchRepository;
        this.tokenValidator = tokenValidator;
        this.memberRepository = memberRepository;
        this.packageRepository = packageRepository;
        this.adminRepository = adminRepository;
        this.registrationRepository = registrationRepository;
    }

    @Override
    public boolean makeNewRegistration(MemberRegistrationRequestDTO dto) {

        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{

            Optional<AdminEntity> byId1 = adminRepository.findById(adminDTO.getAdminId());

            if(byId1.isPresent()) {
                AdminEntity adminEntity = byId1.get();
                BranchEntity branchEntity = adminEntity.getBranchEntity();
//                MemberDTO memberDTO = dto.getMemberDTO();
//                long memberId = memberDTO.getMemberId();
                if(dto.getMemberId() != 0) {
                    // new member registration
                    MemberEntity memberEntity = new MemberEntity();
                    memberEntity.setFiratName(dto.getFiratName());
                    memberEntity.setLastName(dto.getLastName());
                    memberEntity.setDOB(dto.getDOB());
                    memberEntity.setAddress(dto.getAddress());
                    memberEntity.setHomeContact(dto.getHomeContact());
                    memberEntity.setCellContact(dto.getCellContact());
                    memberEntity.setEmail(dto.getEmail());
                    memberEntity.setEmergencyContact(dto.getEmergencyContact());
                    memberEntity.setRole(MemberRoles.COMMON);
                    MemberEntity saveMember = memberRepository.save(memberEntity);
                    if(saveMember != null) {
                        long packageId = dto.getPackageId();
                        Optional<PackageEntity> byId = packageRepository.findById(packageId);
                        if(byId.isPresent()) {
                            PackageEntity packageEntity = byId.get();
                            if(branchEntity != null) {
                                RegistrationEntity registrationEntity = new RegistrationEntity();
                                registrationEntity.setAdminEntity(adminEntity);
                                registrationEntity.setPackageEntity(packageEntity);
                                registrationEntity.setBranchEntity(branchEntity);
                                registrationEntity.setMemberEntity(memberEntity);
                                registrationEntity.setState(ActiveAndDeActive.ACTIVE);
                                RegistrationEntity saveRegistration = registrationRepository.save(registrationEntity);
                                if(saveRegistration != null) {
                                    for (HealthQUAnswerMemberRegDTO d : dto.getMemberHistoryArray()) {

                                    }
                                }
                            }
                        }
                    }
                }else{
                    //already exist member re-registration
                }
            }


        }catch (Exception e){
            throw e;
        }
        return false;
    }
}
