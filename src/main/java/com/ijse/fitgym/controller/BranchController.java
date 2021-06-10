package com.ijse.fitgym.controller;

import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.BranchDTO;
import com.ijse.fitgym.dto.json.request.BranchSaveRequestDTO;
import com.ijse.fitgym.dto.json.response.ResponseDTO;
import com.ijse.fitgym.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/branch")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createNewBranch(@RequestBody BranchSaveRequestDTO dto) {
        boolean newBranch = branchService.createNewBranch(dto);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, newBranch, "Branch createed successfully"), HttpStatus.OK);
    }

    @GetMapping(path = "/get")
    public ResponseEntity getMap() {
        List<BranchDTO> allBranches = branchService.getAllBranches();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "get all branches successfully", allBranches), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity updateBranch(@RequestBody BranchDTO branchDTO) {
        List<BranchDTO> allBranches = branchService.updateBranch(branchDTO);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Branch updated successfully", allBranches), HttpStatus.OK);
    }

    @PatchMapping(path = "/activation/branch/{id}")
    public ResponseEntity changeActivation(@PathVariable long id){
        List<BranchDTO> allBranches = branchService.deactiveBranch(id);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Changed branche activation successfully", allBranches), HttpStatus.OK);
    }

}