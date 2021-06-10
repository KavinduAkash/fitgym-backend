package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.json.request.MemberRegistrationRequestDTO;
import com.ijse.fitgym.dto.json.request.RegisrationSaveRequestDTO;

public interface RegistrationService {
    boolean makeNewRegistration(MemberRegistrationRequestDTO dto);
}
