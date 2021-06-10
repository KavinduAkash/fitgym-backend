package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.PackageDTO;
import com.ijse.fitgym.dto.json.request.PackageSaveRequestDTO;

import java.util.List;

public interface PackageService {
    boolean createNewPackage(PackageSaveRequestDTO dto);
    boolean updatePackage(PackageDTO dto);
    List<PackageDTO> deactivePackage(long id);
    List<PackageDTO> getAllPackages();
    List<PackageDTO> getAllActivePackages();
    List<PackageDTO> getAllDeActivePackages();
}
