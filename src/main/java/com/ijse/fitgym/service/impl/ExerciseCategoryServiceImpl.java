package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.constants.Constants;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.ExerciseCategoryDTO;
import com.ijse.fitgym.dto.json.request.ExerciseCategorySaveRequestDTO;
import com.ijse.fitgym.entity.AdminEntity;
import com.ijse.fitgym.entity.ExerciseCategoryEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import com.ijse.fitgym.enums.UserActiveState;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.exception.FitGymServiceException;
import com.ijse.fitgym.repository.ExerciseCategoryRepository;
import com.ijse.fitgym.service.ExerciseCategoryService;
import com.ijse.fitgym.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExerciseCategoryServiceImpl implements ExerciseCategoryService {

    private final TokenValidator tokenValidator;
    private final ExerciseCategoryRepository exerciseCategoryRepository;

    @Autowired
    public ExerciseCategoryServiceImpl(TokenValidator tokenValidator, ExerciseCategoryRepository exerciseCategoryRepository) {
        this.tokenValidator = tokenValidator;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    @Override
    public List<ExerciseCategoryDTO> createNewExerciseCategory(ExerciseCategorySaveRequestDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
              if(dto != null) {
                  ExerciseCategoryEntity exerciseCategoryEntity = new ExerciseCategoryEntity(dto.getName(), dto.getDescription(), ActiveAndDeActive.ACTIVE);
                  exerciseCategoryRepository.save(exerciseCategoryEntity);
                  List<ExerciseCategoryDTO> allExerciseCategories = getAllExerciseCategories();
                  return allExerciseCategories;
              }
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseCategoryDTO> updateExerciseCategory(ExerciseCategoryDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                if(dto != null) {
                    long catId = dto.getCatId();
                    Optional<ExerciseCategoryEntity> byId = exerciseCategoryRepository.findById(catId);
                    if(byId.isPresent()) {
                        ExerciseCategoryEntity exerciseCategoryEntity = byId.get();
                        exerciseCategoryEntity.setCategoryName(dto.getCategoryName());
                        exerciseCategoryEntity.setCategoryDescription(dto.getCategoryDescription());
                        ExerciseCategoryEntity save = exerciseCategoryRepository.save(exerciseCategoryEntity);
                        List<ExerciseCategoryDTO> allExerciseCategories = getAllExerciseCategories();
                        return allExerciseCategories;
                    }
                    throw new FitGymServiceException(Constants.ACCESS_DENIED, "Can't find exercise category details");
                }
                throw new FitGymServiceException(Constants.ACCESS_DENIED, "There are't any detail in request");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseCategoryDTO> getAllExerciseCategory() {
        try{
            List<ExerciseCategoryDTO> allExerciseCategories = getAllExerciseCategories();
            return allExerciseCategories;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseCategoryDTO> getAllActiveExerciseCategory() {
        try{
            List<ExerciseCategoryEntity> all = exerciseCategoryRepository.getAllActiveExerciseCat(ActiveAndDeActive.ACTIVE);
            List<ExerciseCategoryDTO> exerciseCategoryDTOS =  new ArrayList<>();
            for (ExerciseCategoryEntity e:all) {
                ExerciseCategoryDTO exerciseCategoryDTO = new ExerciseCategoryDTO(e.getCatId(), e.getCategoryName(), e.getCategoryDescription(), e.getState());
                exerciseCategoryDTOS.add(exerciseCategoryDTO);
            }
            return exerciseCategoryDTOS;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseCategoryDTO> getAllDeActiveExerciseCategory() {
        try{
            List<ExerciseCategoryEntity> all = exerciseCategoryRepository.getAllActiveExerciseCat(ActiveAndDeActive.DEACTIVE);
            List<ExerciseCategoryDTO> exerciseCategoryDTOS =  new ArrayList<>();
            for (ExerciseCategoryEntity e:all) {
                ExerciseCategoryDTO exerciseCategoryDTO = new ExerciseCategoryDTO(e.getCatId(), e.getCategoryName(), e.getCategoryDescription(), e.getState());
                exerciseCategoryDTOS.add(exerciseCategoryDTO);
            }
            return exerciseCategoryDTOS;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ExerciseCategoryDTO> deActiveExerciseCategory(long id) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                if(id != 0) {
                    Optional<ExerciseCategoryEntity> byId = exerciseCategoryRepository.findById(id);
                    if(byId.isPresent()) {
                        ExerciseCategoryEntity exerciseCategoryEntity = byId.get();
                        if(exerciseCategoryEntity.getState() == ActiveAndDeActive.ACTIVE) {
                            exerciseCategoryEntity.setState(ActiveAndDeActive.DEACTIVE);
                            exerciseCategoryRepository.save(exerciseCategoryEntity);
                        }else {
                            exerciseCategoryEntity.setState(ActiveAndDeActive.ACTIVE);
                            exerciseCategoryRepository.save(exerciseCategoryEntity);
                        }
                        List<ExerciseCategoryDTO> allExerciseCategories = getAllExerciseCategories();
                        return allExerciseCategories;
                    }
                    throw new FitGymServiceException(Constants.ACCESS_DENIED, "Can't find exercise category details");
                }
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    private List<ExerciseCategoryDTO> getAllExerciseCategories() {
        try{
            List<ExerciseCategoryEntity> all = exerciseCategoryRepository.findAll();
            List<ExerciseCategoryDTO> exerciseCategoryDTOS =  new ArrayList<>();
            for (ExerciseCategoryEntity e:all) {
                ExerciseCategoryDTO exerciseCategoryDTO = new ExerciseCategoryDTO(e.getCatId(), e.getCategoryName(), e.getCategoryDescription(), e.getState());
                exerciseCategoryDTOS.add(exerciseCategoryDTO);
            }
            return exerciseCategoryDTOS;
        }catch (Exception e){
            throw e;
        }
    }
}
