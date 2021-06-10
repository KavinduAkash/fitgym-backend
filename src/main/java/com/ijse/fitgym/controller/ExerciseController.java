package com.ijse.fitgym.controller;

import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.ExerciseCategoryDTO;
import com.ijse.fitgym.dto.ExerciseDTO;
import com.ijse.fitgym.dto.json.request.ExerciseCategorySaveRequestDTO;
import com.ijse.fitgym.dto.json.request.ExerciseSaveRequestDTO;
import com.ijse.fitgym.dto.json.response.ResponseDTO;
import com.ijse.fitgym.service.ExerciseCategoryService;
import com.ijse.fitgym.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/exercise")
public class ExerciseController {

    private final ExerciseCategoryService exerciseCategoryService;
    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseCategoryService exerciseCategoryService, ExerciseService exerciseService) {
        this.exerciseCategoryService = exerciseCategoryService;
        this.exerciseService = exerciseService;
    }

    //exercise category
    @PostMapping(path = "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewExerciseCategory(@RequestBody ExerciseCategorySaveRequestDTO exerciseCategorySaveRequestDTO) {
        List<ExerciseCategoryDTO> allExerciseCategories = exerciseCategoryService.createNewExerciseCategory(exerciseCategorySaveRequestDTO);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Exercise category created successfully", allExerciseCategories), HttpStatus.OK);
    }

    @GetMapping(path = "/category/get")
    public ResponseEntity getAllExerciseCategory() {
        List<ExerciseCategoryDTO> allExerciseCategories = exerciseCategoryService.getAllExerciseCategory();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Exercise category created successfully", allExerciseCategories), HttpStatus.OK);
    }

    @GetMapping(path = "/category/get/active")
    public ResponseEntity getAllActiveExerciseCategory() {
        List<ExerciseCategoryDTO> allExerciseCategories = exerciseCategoryService.getAllActiveExerciseCategory();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Exercise category created successfully", allExerciseCategories), HttpStatus.OK);
    }

    @GetMapping(path = "/category/get/deactive")
    public ResponseEntity getAllDeActiveExerciseCategory() {
        List<ExerciseCategoryDTO> allExerciseCategories = exerciseCategoryService.getAllDeActiveExerciseCategory();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Exercise category created successfully", allExerciseCategories), HttpStatus.OK);
    }

    @PutMapping(path = "/category/active/change/{id}")
    public ResponseEntity changeActiveExerciseCategory(@PathVariable long id) {
        List<ExerciseCategoryDTO> allExerciseCategories = exerciseCategoryService.deActiveExerciseCategory(id);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Exercise category updated successfully", allExerciseCategories), HttpStatus.OK);
    }

    @PutMapping(path = "/category/update")
    public ResponseEntity updateExerciseCategory(@RequestBody ExerciseCategoryDTO exerciseCategoryDTO) {
        List<ExerciseCategoryDTO> allExerciseCategories = exerciseCategoryService.updateExerciseCategory(exerciseCategoryDTO);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Exercise category updated successfully", allExerciseCategories), HttpStatus.OK);
    }

    //exercise
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewExercise(@RequestBody ExerciseSaveRequestDTO exerciseSaveRequestDTO) {
        List<ExerciseDTO> allExercises = exerciseService.createNewExercise(exerciseSaveRequestDTO);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Exercise created successfully", allExercises), HttpStatus.OK);
    }

    @GetMapping(path = "/all/get")
    public ResponseEntity getExercises() {
        System.out.println("IT IS HERE");
        List<ExerciseDTO> allExercises = exerciseService.getAllExercise();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Get all exercises successfully", allExercises), HttpStatus.OK);
    }
}
