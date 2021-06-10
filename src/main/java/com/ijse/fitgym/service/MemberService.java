package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.json.response.MemberSearchResponseDTO;

import java.util.List;

public interface MemberService {
    List<MemberSearchResponseDTO> searchMember(String contactNumber, int type);
}
