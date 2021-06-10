package com.ijse.fitgym.util;

import com.ijse.fitgym.dto.AdminDTO;
import com.ijse.fitgym.entity.AdminEntity;
import com.ijse.fitgym.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class TokenValidator {

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public TokenValidator(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    public AdminDTO retrieveUserInformationFromAuthentication() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                return customUserDetailsService.findAdmin(authentication.getName());
            }
            return null;
//            throw new VisitorTagServiceException(RESOURCE_NOT_FOUND, "Can't find user details from token");
        } catch (Exception e) {
//            LOGGER.error("Method retrieveUserInformationFromAuthentication : " + e.getMessage());
            throw e;
        }
    }
}
