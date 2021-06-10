package com.ijse.fitgym.service.impl;

import com.ijse.fitgym.dto.MemberDTO;
import com.ijse.fitgym.dto.json.response.MemberSearchResponseDTO;
import com.ijse.fitgym.entity.MemberEntity;
import com.ijse.fitgym.repository.MemberRepository;
import com.ijse.fitgym.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberSearchResponseDTO> searchMember(String contactNumber, int type) {
        try{
            String contactType = type != 1 ? "homeContact" : "cellContact";
            List<MemberEntity> memberEntities = memberRepository.searchMember(contactNumber, contactType);
            List<MemberSearchResponseDTO> memberSearchResponseDTOS =  new ArrayList<>();
            if(memberEntities != null) {
                for (MemberEntity m : memberEntities) {
                    ModelMapper modelMapper = new ModelMapper();
                    MemberDTO map = modelMapper.map(m, MemberDTO.class);
                    MemberSearchResponseDTO memberSearchResponseDTO = new MemberSearchResponseDTO(map);
                    memberSearchResponseDTOS.add(memberSearchResponseDTO);
                }
                return memberSearchResponseDTOS;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
