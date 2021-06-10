package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.constants.Constants;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.BranchDTO;
import com.ijse.fitgym.dto.json.request.BranchSaveRequestDTO;
import com.ijse.fitgym.dto.json.response.BranchesCountResponseDTO;
import com.ijse.fitgym.entity.BranchEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.exception.FitGymServiceException;
import com.ijse.fitgym.repository.BranchRepository;
import com.ijse.fitgym.service.BranchService;
import com.ijse.fitgym.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final TokenValidator tokenValidator;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, TokenValidator tokenValidator) {
        this.branchRepository = branchRepository;
        this.tokenValidator = tokenValidator;
    }

    @Override
    public boolean createNewBranch(BranchSaveRequestDTO dto) {

        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        System.out.println("ADMIN: "+adminDTO);
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER){
            if(dto != null) {
                String name = dto.getName();
                String address = dto.getAddress();
                String contact = dto.getContact();
                Date date = new Date();
                BranchEntity branchEntity = new BranchEntity(name, address,  "", "", contact, date, ActiveAndDeActive.ACTIVE );
                BranchEntity save = branchRepository.save(branchEntity);
                return true;
            }
            throw new FitGymServiceException(Constants.SOMETHING_WENT_WRONG, "Something went wrong");
        }
        throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<BranchDTO> updateBranch(BranchDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                Optional<BranchEntity> byId = branchRepository.findById(dto.getBranchId());
                if (byId.isPresent()) {
                    BranchEntity branchEntity = byId.get();
                    branchEntity.setBranchName(dto.getBranchName());
                    branchEntity.setBranchAddress(dto.getBranchAddress());
                    branchEntity.setContact(dto.getContact());
                    BranchEntity save = branchRepository.save(branchEntity);
                    List<BranchDTO> branches = new ArrayList<>();
                    if(save != null) {
                        branches = this.getBranches();
                    }
                    return branches;
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found branch details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<BranchDTO> deactiveBranch(long id) {
        try {
            AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                Optional<BranchEntity> byId = branchRepository.findById(id);
                if (byId.isPresent()) {
                    BranchEntity branchEntity = byId.get();
                    ActiveAndDeActive state = branchEntity.getState();
                    if(state == ActiveAndDeActive.ACTIVE) {
                        branchEntity.setState(ActiveAndDeActive.DEACTIVE);
                    }else if (state == ActiveAndDeActive.DEACTIVE){
                        branchEntity.setState(ActiveAndDeActive.ACTIVE);
                    }else{
                        branchEntity.setState(ActiveAndDeActive.ACTIVE);
                    }
                    BranchEntity save = branchRepository.save(branchEntity);
                    List<BranchDTO> branches = new ArrayList<>();
                    if(save != null) {
                        branches = this.getBranches();
                    }
                    return branches;
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found branch details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        try{
            List<BranchEntity> all = branchRepository.findAll();
            List<BranchDTO> allBranches =  new ArrayList<>();
            for (BranchEntity e:all) {
                BranchDTO branchDTO = new BranchDTO(e.getBranchId(), e.getBranchName(), e.getBranchAddress(), e.getContact(), e.getLongitude(), e.getLatitude(), e.getDate(), e.getState());
                allBranches.add(branchDTO);
            }
            return allBranches;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<BranchDTO> searchBranches(String name) {
        try {
            List<BranchEntity> branchByNameSuggestion = branchRepository.findBranchByNameSuggestion(name);
            List<BranchDTO> searchedBranches =  new ArrayList<>();
            for (BranchEntity e:branchByNameSuggestion) {
                BranchDTO branchDTO = new BranchDTO(e.getBranchId(), e.getBranchName(), e.getBranchAddress(), e.getContact(), e.getLongitude(), e.getLatitude(), e.getDate(), e.getState());
                searchedBranches.add(branchDTO);
            }
            return searchedBranches;

        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public BranchesCountResponseDTO branchesCountDetails() {
        try {

            List<BranchEntity> all = branchRepository.findAll();
            int allCount = all.size();
            int activeCount = branchRepository.getActiveORDeactiveBranchCount(ActiveAndDeActive.ACTIVE);
            int deActiveCount = branchRepository.getActiveORDeactiveBranchCount(ActiveAndDeActive.DEACTIVE);
            BranchesCountResponseDTO branchesCountResponseDTO = new BranchesCountResponseDTO(allCount, activeCount, deActiveCount);
            return branchesCountResponseDTO;

        }catch (Exception e) {
            throw e;
        }
    }

    private List<BranchDTO> getBranches() {
        try{
            List<BranchEntity> all = branchRepository.findAll();
            List<BranchDTO> allBranches =  new ArrayList<>();
            for (BranchEntity e:all) {
                BranchDTO branchDTO = new BranchDTO(e.getBranchId(), e.getBranchName(), e.getBranchAddress(), e.getContact(), e.getLongitude(), e.getLatitude(), e.getDate(), e.getState());
                allBranches.add(branchDTO);
            }
            return allBranches;
        }catch (Exception e){
            throw e;
        }
    }
}
