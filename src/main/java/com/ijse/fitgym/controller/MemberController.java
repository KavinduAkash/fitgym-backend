package com.ijse.fitgym.controller;

import com.ijse.fitgym.constants.ResponseCode;
import com.ijse.fitgym.dto.json.request.MemberRegistrationRequestDTO;
import com.ijse.fitgym.dto.json.response.MemberSearchResponseDTO;
import com.ijse.fitgym.dto.json.response.ResponseDTO;
import com.ijse.fitgym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity registerMember(@RequestBody MemberRegistrationRequestDTO memberRegistrationRequestDTO) {
//        memberService.
        return null;
    }

    @GetMapping(path = "/get")
    public ResponseEntity getAllMembers() {
        return null;
    }

    @GetMapping(path = "/count")
    public ResponseEntity getMembersCounts() {
        return null;
    }

    @GetMapping(path = "/branch/{branchId}/get")
    public ResponseEntity getAllBranchMembers(@PathVariable("branchId") long branchId) {
        return null;
    }

    @GetMapping(path = "/branch/{branchId}/count")
    public ResponseEntity getBranchMemberCount(@PathVariable("branchId") long branchId) {
        return null;
    }

    @GetMapping(path = "/{id}/get")
    public ResponseEntity getMemberDetailsById(@PathVariable("id") long id) {
        return null;
    }

    @GetMapping(path = "/search/{contact}/type/{type}")
    public ResponseEntity searchMemberDetails(@PathVariable("contact") String contact, @PathVariable("type") int type) {
        List<MemberSearchResponseDTO> memberSearchResponseDTOS = memberService.searchMember(contact, type);
        return new ResponseEntity(new ResponseDTO(ResponseCode.SUCCESS, true, "Search contact successfully", memberSearchResponseDTOS), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity updateMember() {
        return null;
    }

}
