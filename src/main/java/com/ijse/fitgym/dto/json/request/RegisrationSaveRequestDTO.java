package com.ijse.fitgym.dto.json.request;

import com.ijse.fitgym.dto.MemberDTO;
import com.ijse.fitgym.dto.json.request.sub.HealthQuestionFillDTO;

import java.util.List;

public class RegisrationSaveRequestDTO {

    private MemberDTO memberDTO;
    private long packageId;
    private List<HealthQuestionFillDTO> healthQuestion;

    public RegisrationSaveRequestDTO() {
    }

    public RegisrationSaveRequestDTO(MemberDTO memberDTO, long packageId, List<HealthQuestionFillDTO> healthQuestion) {
        this.memberDTO = memberDTO;
        this.packageId = packageId;
        this.healthQuestion = healthQuestion;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    public List<HealthQuestionFillDTO> getHealthQuestion() {
        return healthQuestion;
    }

    public void setHealthQuestion(List<HealthQuestionFillDTO> healthQuestion) {
        this.healthQuestion = healthQuestion;
    }

    @Override
    public String toString() {
        return "RegisrationSaveRequestDTO{" +
                "memberDTO=" + memberDTO +
                ", packageId=" + packageId +
                ", healthQuestion=" + healthQuestion +
                '}';
    }
}
