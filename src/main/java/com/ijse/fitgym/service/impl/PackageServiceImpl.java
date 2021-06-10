package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.constants.Constants;
import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.dto.PackageDTO;
import com.ijse.fitgym.dto.json.request.PackageSaveRequestDTO;
import com.ijse.fitgym.entity.PackageEntity;
import com.ijse.fitgym.enums.UserRoles;
import com.ijse.fitgym.exception.FitGymServiceException;
import com.ijse.fitgym.repository.PackageRepository;
import com.ijse.fitgym.service.PackageService;
import com.ijse.fitgym.util.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final TokenValidator tokenValidator;

    @Autowired
    public PackageServiceImpl(PackageRepository packageRepository, TokenValidator tokenValidator) {
        this.packageRepository = packageRepository;
        this.tokenValidator = tokenValidator;
    }

    @Override
    public boolean createNewPackage(PackageSaveRequestDTO dto) {
        System.out.println("S2");
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            System.out.println("S3");
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                String name = dto.getName();
                String description = dto.getDescription();
                String duration = dto.getDuration();
                double fee = dto.getFee();
                Date date = new Date();
                System.out.println("S4");
                PackageEntity packageEntity = new PackageEntity(name, description, 0, duration, date, fee, null);
                System.out.println("S6");
                PackageEntity save = packageRepository.save(packageEntity);
                System.out.println("S7");
                return true;
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            System.out.println("S8: "+e);
            throw e;
        }
    }

    @Override
    public boolean updatePackage(PackageDTO dto) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                Optional<PackageEntity> byId = packageRepository.findById(dto.getPackageId());
                if (byId.isPresent()) {
                    PackageEntity packageEntity = byId.get();
                    packageEntity.setPackageName(dto.getPackageName());
                    packageEntity.setPackageDescription(dto.getPackageDescription());
                    packageEntity.setDuration(0);
                    packageEntity.setDurationISO(dto.getDuration());
                    packageEntity.setDate(dto.getDate());
                    packageEntity.setFee(dto.getFee());
                    packageEntity.setExpDate(dto.getExpDate());
                    PackageEntity save = packageRepository.save(packageEntity);
                    return true;
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found package details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<PackageDTO> deactivePackage(long id) {
        AdminDTO adminDTO = tokenValidator.retrieveUserInformationFromAuthentication();
        try{
            if(adminDTO.getUserRoles() == UserRoles.SUPER) {
                Optional<PackageEntity> byId = packageRepository.findById(id);
                if (byId.isPresent()) {
                    PackageEntity packageEntity = byId.get();
                    packageEntity.setExpDate(new Date());
                    PackageEntity save = packageRepository.save(packageEntity);
                    List<PackageDTO> packages = getPackages();
                    return packages;
                }
                throw new FitGymServiceException(Constants.CANT_FOUND, "Can't found package details");
            }
            throw new FitGymServiceException(Constants.ACCESS_DENIED, "Access denied");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<PackageDTO> getAllPackages() {
        try{

//            List<PackageEntity> all = packageRepository.findAll();
//            List<PackageDTO> allPackages = new ArrayList<>();
//            for (PackageEntity e :all) {
//                PackageDTO packageDTO = new PackageDTO(e.getPackageId(), e.getPackageName(), e.getPackageDescription(), e.getDurationISO(), e.getDate(), e.getFee(), e.getExpDate());
//                allPackages.add(packageDTO);
//            }
            List<PackageDTO> allPackages = getPackages();
            return allPackages;

        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public List<PackageDTO> getAllActivePackages() {
        try{

            List<PackageEntity> all = packageRepository.getAllActivePackages();
            List<PackageDTO> allPackages = new ArrayList<>();
            for (PackageEntity e :all) {
                PackageDTO packageDTO = new PackageDTO(e.getPackageId(), e.getPackageName(), e.getPackageDescription(), e.getDurationISO(), e.getDate(), e.getFee(), e.getExpDate());
                allPackages.add(packageDTO);
            }
            return allPackages;

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<PackageDTO> getAllDeActivePackages() {
        try{

            List<PackageEntity> all = packageRepository.getAllDeActivePackages();
            List<PackageDTO> allPackages = new ArrayList<>();
            for (PackageEntity e :all) {
                PackageDTO packageDTO = new PackageDTO(e.getPackageId(), e.getPackageName(), e.getPackageDescription(), e.getDurationISO(), e.getDate(), e.getFee(), e.getExpDate());
                allPackages.add(packageDTO);
            }
            return allPackages;

        }catch (Exception e){
            throw e;
        }
    }

    private List<PackageDTO> getPackages() {
        try{

            List<PackageEntity> all = packageRepository.findAll();
            List<PackageDTO> allPackages = new ArrayList<>();
            for (PackageEntity e :all) {
                PackageDTO packageDTO = new PackageDTO(e.getPackageId(), e.getPackageName(), e.getPackageDescription(), e.getDurationISO(), e.getDate(), e.getFee(), e.getExpDate());
                allPackages.add(packageDTO);
            }
            return allPackages;

        }catch (Exception e){
            throw e;
        }
    }
}
