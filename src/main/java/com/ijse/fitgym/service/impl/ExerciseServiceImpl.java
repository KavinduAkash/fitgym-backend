package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.constants.Constants;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.ExerciseCategoryDTO;
import com.ijse.fitgym.dto.ExerciseDTO;
import com.ijse.fitgym.dto.json.request.ExerciseSaveRequestDTO;
import com.ijse.fitgym.dto.json.request.ExerciseUpdateRequestDTO;
import com.ijse.fitgym.entity.BranchEntity;
import com.ijse.fitgym.entity.ExerciseCategoryEntity;
import com.ijse.fitgym.entity.ExerciseEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.exception.FitGymServiceException;
import com.ijse.fitgym.repository.ExerciseCategoryRepository;
import com.ijse.fitgym.repository.ExerciseRepository;
import com.ijse.fitgym.service.ExerciseService;
import com.ijse.fitgym.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final TokenValidator tokenValidator;
    private final ExerciseRepository exerciseRepository;
    private final ExerciseCategoryRepository exerciseCategoryRepository;

    @Autowired
    public ExerciseServiceImpl(TokenValidator tokenValidator, ExerciseRepository exerciseRepository, ExerciseCategoryRepository exerciseCategoryRepository) {
        this.tokenValidator = tokenValidator;
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    @Override
    public List<ExerciseDTO> createNewExercise(ExerciseSaveRequestDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        System.out.println("ADMIN: "+adminDTO);
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER){
                if(dto != null) {
                    Optional<ExerciseCategoryEntity> byId = exerciseCategoryRepository.findById(dto.getCatId());
                    if(byId.isPresent()) {
                        ExerciseCategoryEntity exerciseCategoryEntity = byId.get();
                        ExerciseEntity exerciseEntity = new ExerciseEntity();
                        exerciseEntity.setExerciseName(dto.getName());
                        exerciseEntity.setExerciseDescription(dto.getDescription());
                        exerciseEntity.setCategoryEntity(exerciseCategoryEntity);
                        exerciseEntity.setState(ActiveAndDeActive.ACTIVE);
                        ExerciseEntity save = exerciseRepository.save(exerciseEntity);
                        List<ExerciseDTO> exercises = getExercises();
                        return exercises;
                    }
                    throw new FitGymServiceException(Constants.CANT_FOUND, "Can\'t find exercise category details");
                }
                throw new FitGymServiceException(Constants.SOMETHING_WENT_WRONG, "Something went wrong");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseDTO> getAllExercise() {
        try{
            List<ExerciseDTO> allExercise = getExercises();
            return allExercise;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseDTO> getAciveExercise() {
        try{
            List<ExerciseEntity> all = exerciseRepository.getAllActiveExercise(ActiveAndDeActive.ACTIVE);
            List<ExerciseDTO> exerciseDTOS =  new ArrayList<>();
            for (ExerciseEntity ex:all) {
                ExerciseCategoryEntity e = ex.getCategoryEntity();
                ExerciseCategoryDTO exerciseCategoryDTO = new ExerciseCategoryDTO(e.getCatId(), e.getCategoryName(), e.getCategoryDescription(), e.getState());
                ExerciseDTO exerciseDTO = new ExerciseDTO(ex.getExerciseId(), ex.getExerciseName(), ex.getExerciseDescription(), exerciseCategoryDTO, ex.getState());
                exerciseDTOS.add(exerciseDTO);
            }
            return exerciseDTOS;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseDTO> getDeAciveExercise() {
        try{
            List<ExerciseEntity> all = exerciseRepository.getAllActiveExercise(ActiveAndDeActive.DEACTIVE);
            List<ExerciseDTO> exerciseDTOS =  new ArrayList<>();
            for (ExerciseEntity ex:all) {
                ExerciseCategoryEntity e = ex.getCategoryEntity();
                ExerciseCategoryDTO exerciseCategoryDTO = new ExerciseCategoryDTO(e.getCatId(), e.getCategoryName(), e.getCategoryDescription(), e.getState());
                ExerciseDTO exerciseDTO = new ExerciseDTO(ex.getExerciseId(), ex.getExerciseName(), ex.getExerciseDescription(), exerciseCategoryDTO, ex.getState());
                exerciseDTOS.add(exerciseDTO);
            }
            return exerciseDTOS;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseDTO> changeActivationExercise(long id) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        System.out.println("ADMIN: "+adminDTO);
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER){
                Optional<ExerciseEntity> byId = exerciseRepository.findById(id);
                if(byId.isPresent()) {
                    ExerciseEntity exerciseEntity = byId.get();
                    if(exerciseEntity.getState() == ActiveAndDeActive.ACTIVE) {
                        exerciseEntity.setState(ActiveAndDeActive.DEACTIVE);
                    }else{
                        exerciseEntity.setState(ActiveAndDeActive.ACTIVE);
                    }
                    ExerciseEntity save = exerciseRepository.save(exerciseEntity);
                    List<ExerciseDTO> exercises = getExercises();
                    return exercises;
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can\'t find exercise category details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseDTO> updateExercise(ExerciseUpdateRequestDTO dto) {
        return null;
    }

    private List<ExerciseDTO> getExercises() {
        try{
            List<ExerciseEntity> all = exerciseRepository.findAll();
            List<ExerciseDTO> exerciseDTOS =  new ArrayList<>();
            for (ExerciseEntity ex:all) {
                ExerciseCategoryEntity e = ex.getCategoryEntity();
                ExerciseCategoryDTO exerciseCategoryDTO = new ExerciseCategoryDTO(e.getCatId(), e.getCategoryName(), e.getCategoryDescription(), e.getState());
                ExerciseDTO exerciseDTO = new ExerciseDTO(ex.getExerciseId(), ex.getExerciseName(), ex.getExerciseDescription(), exerciseCategoryDTO, ex.getState());
                exerciseDTOS.add(exerciseDTO);
            }
            return exerciseDTOS;
        }catch (Exception e){
            throw e;
        }
    }
}
