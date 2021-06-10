package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.constants.Constants;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.HealthHistoryDTO;
import com.ijse.fitgym.dto.json.request.HealthQuetionSaveRequestDTO;
import com.ijse.fitgym.entity.HealthHistoryEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.exception.FitGymServiceException;
import com.ijse.fitgym.repository.HealthHistoryRepository;
import com.ijse.fitgym.service.HealtHistoryService;
import com.ijse.fitgym.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HealthHistoryImpl implements HealtHistoryService {

    private final HealthHistoryRepository healthHistoryRepository;
    private final TokenValidator tokenValidator;

    @Autowired
    public HealthHistoryImpl(HealthHistoryRepository healthHistoryRepository, TokenValidator tokenValidator) {
        this.healthHistoryRepository = healthHistoryRepository;
        this.tokenValidator = tokenValidator;
    }

    @Override
    public List<HealthHistoryDTO> saveNewHealthQuetion(HealthQuetionSaveRequestDTO dto) {
        try{
                String quetion = dto.getQuetion();
            System.out.println("DTO: "+quetion);
                HealthHistoryEntity healthHistoryEntity = new HealthHistoryEntity(quetion, ActiveAndDeActive.ACTIVE);
                HealthHistoryEntity save = healthHistoryRepository.save(healthHistoryEntity);
                List<HealthHistoryDTO> healthHistoryQuestions = getHealthHistoryQuestions();
                return healthHistoryQuestions;
        }catch (Exception e){
                throw e;
        }
    }

    @Override
    public List<HealthHistoryDTO> updateHealthQuetion(HealthHistoryDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                Optional<HealthHistoryEntity> byId = healthHistoryRepository.findById(dto.getId());
                if(byId.isPresent()) {
                    HealthHistoryEntity healthHistoryEntity = byId.get();
                    healthHistoryEntity.setQuestion(dto.getQuetion());
                    healthHistoryEntity.setState(dto.getState());
                    HealthHistoryEntity save = healthHistoryRepository.save(healthHistoryEntity);
                    List<HealthHistoryDTO> healthHistoryQuestions = getHealthHistoryQuestions();
                    return healthHistoryQuestions;
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found health question details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<HealthHistoryDTO> getAllHealthHistoryQuestion() {
        try{
            List<HealthHistoryDTO> healthHistoryQuestions = getHealthHistoryQuestions();
            return healthHistoryQuestions;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<HealthHistoryDTO> getAllActiveHealthHistoryQuestion() {
        try{
            List<HealthHistoryEntity> activeHealthHistory = healthHistoryRepository.getActiveORDeactiveHealthHistory(ActiveAndDeActive.ACTIVE);
            List<HealthHistoryDTO> dtos = new ArrayList<>();
            for (HealthHistoryEntity he : activeHealthHistory) {
                HealthHistoryDTO healthHistoryDTO = new HealthHistoryDTO(he.getId(), he.getQuestion(), he.getState());
                dtos.add(healthHistoryDTO);
            }
            return dtos;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<HealthHistoryDTO> activeChange(long id) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                Optional<HealthHistoryEntity> byId = healthHistoryRepository.findById(id);
                if(byId.isPresent()) {
                    HealthHistoryEntity healthHistoryEntity = byId.get();
                    ActiveAndDeActive state = healthHistoryEntity.getState();
                    if(state == ActiveAndDeActive.ACTIVE) {
                        healthHistoryEntity.setState(ActiveAndDeActive.DEACTIVE);
                    }else{
                        healthHistoryEntity.setState(ActiveAndDeActive.ACTIVE);
                    }
                    HealthHistoryEntity save = healthHistoryRepository.save(healthHistoryEntity);
                    List<HealthHistoryDTO> healthHistoryQuestions = getHealthHistoryQuestions();
                    return healthHistoryQuestions;
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found health question details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    private List<HealthHistoryDTO> getHealthHistoryQuestions() {
        try{
            List<HealthHistoryEntity> all = healthHistoryRepository.findAll();
            List<HealthHistoryDTO> dtos = new ArrayList<>();
            for (HealthHistoryEntity he : all) {
                HealthHistoryDTO healthHistoryDTO = new HealthHistoryDTO(he.getId(), he.getQuestion(), he.getState());
                dtos.add(healthHistoryDTO);
            }
            return dtos;
        }catch (Exception e){
            throw e;
        }
    }
}
