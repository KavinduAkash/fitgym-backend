package com.ijse.fitgym.dto.json.response;

public class BranchesCountResponseDTO {
    private int branchCount;
    private int activeBranchCount;
    private int deActiveBranchCount;

    public BranchesCountResponseDTO() {
    }

    public BranchesCountResponseDTO(int branchCount, int activeBranchCount, int deActiveBranchCount) {
        this.branchCount = branchCount;
        this.activeBranchCount = activeBranchCount;
        this.deActiveBranchCount = deActiveBranchCount;
    }

    public int getBranchCount() {
        return branchCount;
    }

    public void setBranchCount(int branchCount) {
        this.branchCount = branchCount;
    }

    public int getActiveBranchCount() {
        return activeBranchCount;
    }

    public void setActiveBranchCount(int activeBranchCount) {
        this.activeBranchCount = activeBranchCount;
    }

    public int getDeActiveBranchCount() {
        return deActiveBranchCount;
    }

    public void setDeActiveBranchCount(int deActiveBranchCount) {
        this.deActiveBranchCount = deActiveBranchCount;
    }

    @Override
    public String toString() {
        return "BranchesCountResponseDTO{" +
                "branchCount=" + branchCount +
                ", activeBranchCount=" + activeBranchCount +
                ", deActiveBranchCount=" + deActiveBranchCount +
                '}';
    }
}
