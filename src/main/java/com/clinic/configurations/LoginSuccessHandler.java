package com.clinic.configurations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("ROLE_ADMIN")) {
            redirectURL = "admin_page";
        } else if (userDetails.hasRole("ROLE_DOCTOR")) {
            redirectURL = "doctor_page";
        } else if (userDetails.hasRole("ROLE_PATIENT")) {
            redirectURL = "patient_page";
        } else {
            redirectURL = "home";
        }
        response.sendRedirect(redirectURL);
    }
}
