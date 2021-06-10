package com.ijse.fitgym.controller;

import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.HealthHistoryDTO;
import com.ijse.fitgym.dto.json.request.HealthQuetionSaveRequestDTO;
import com.ijse.fitgym.dto.json.response.ResponseDTO;
import com.ijse.fitgym.service.HealtHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/health")
public class HealthHistoryController {

    private final HealtHistoryService healtHistoryService;

    @Autowired
    public HealthHistoryController(HealtHistoryService healtHistoryService) {
        this.healtHistoryService = healtHistoryService;
    }

    @PostMapping(path = "/history/create")
    public ResponseEntity createHealthHistory(@RequestBody HealthQuetionSaveRequestDTO dto){
        System.out.println("PRE-DTO: "+dto.toString());
        List<HealthHistoryDTO> all = healtHistoryService.saveNewHealthQuetion(dto);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Health question successfully", all), HttpStatus.OK);
    }

    @GetMapping(path = "/history/get")
    public ResponseEntity getAllHealthHistory() {
        List<HealthHistoryDTO> allHealthHistoryQuestion = healtHistoryService.getAllHealthHistoryQuestion();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Health question get successfully", allHealthHistoryQuestion), HttpStatus.OK);
    }

    @GetMapping(path = "/history/get/active")
    public ResponseEntity getActiveHealthHistory() {
        List<HealthHistoryDTO> allHealthHistoryQuestion = healtHistoryService.getAllActiveHealthHistoryQuestion();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Health question get successfully", allHealthHistoryQuestion), HttpStatus.OK);
    }

    @PutMapping(path = "/history/update")
    public ResponseEntity updateHealthHistory(@RequestBody HealthHistoryDTO healthHistoryDTO){
        List<HealthHistoryDTO> healthHistoryDTOS = healtHistoryService.updateHealthQuetion(healthHistoryDTO);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Health question has been updated successfully", healthHistoryDTOS), HttpStatus.OK);
    }

    @PatchMapping(path = "/history/{id}/active")
    public ResponseEntity deActiveHealthHistory(@PathVariable("id") long id) {
        List<HealthHistoryDTO> healthHistoryDTOS = healtHistoryService.activeChange(id);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Health question activation change successfully", healthHistoryDTOS), HttpStatus.OK);
    }





    @PutMapping(path = "member/history/update")
    public ResponseEntity updateMemberHealthHistory() {
        return null;
    }

}
