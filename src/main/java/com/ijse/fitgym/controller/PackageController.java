package com.ijse.fitgym.controller;

import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.PackageDTO;
import com.ijse.fitgym.dto.json.request.PackageSaveRequestDTO;
import com.ijse.fitgym.dto.json.response.ResponseDTO;
import com.ijse.fitgym.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/package")
public class PackageController {

    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity creataNewPackage(@RequestBody PackageSaveRequestDTO packageSaveRequestDTO) {
        System.out.println("S1");
        boolean newPackage = packageService.createNewPackage(packageSaveRequestDTO);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Package created successfully"), HttpStatus.OK);
    }

    @GetMapping(path = "/get")
    public ResponseEntity getAllPackages() {
        List<PackageDTO> allPackages = packageService.getAllPackages();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Get all packages successfully", allPackages), HttpStatus.OK);
    }

    @GetMapping(path = "/get/active")
    public ResponseEntity getAllActivePackages() {
        List<PackageDTO> allPackages = packageService.getAllActivePackages();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Get active packages successfully", allPackages), HttpStatus.OK);
    }

    @GetMapping(path = "/get/deactive")
    public ResponseEntity getAllDeActivePackages() {
        List<PackageDTO> allPackages = packageService.getAllDeActivePackages();
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Get de-active packages successfully", allPackages), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity deletePackage(@PathVariable long id) {
        List<PackageDTO> allPackages = packageService.deactivePackage(id);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Delete package successfully", allPackages), HttpStatus.OK);
    }
}
