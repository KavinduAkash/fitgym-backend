package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.BranchDTO;
import com.ijse.fitgym.dto.json.request.BranchSaveRequestDTO;
import com.ijse.fitgym.dto.json.response.BranchesCountResponseDTO;

import java.util.List;

public interface BranchService {
    boolean createNewBranch(BranchSaveRequestDTO dto);
    List<BranchDTO> updateBranch(BranchDTO dto);
    List<BranchDTO> deactiveBranch(long id);
    List<BranchDTO> getAllBranches();
    List<BranchDTO> searchBranches(String name);
    BranchesCountResponseDTO branchesCountDetails();

}
