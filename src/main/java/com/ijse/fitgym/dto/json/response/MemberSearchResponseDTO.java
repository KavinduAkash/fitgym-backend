package com.ijse.fitgym.dto.json.response;

import com.ijse.fitgym.dto.MemberDTO;

public class MemberSearchResponseDTO {
    private MemberDTO memberDTO;

    public MemberSearchResponseDTO() {
    }

    public MemberSearchResponseDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    @Override
    public String toString() {
        return "MemberSearchResponseDTO{" +
                "memberDTO=" + memberDTO +
                '}';
    }
}
