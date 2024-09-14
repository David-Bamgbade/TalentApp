package com.TalentManagement.service;

import com.TalentManagement.dto.request.EmployerLoginRequest;
import com.TalentManagement.dto.request.EmployerLogoutRequest;
import com.TalentManagement.dto.request.EmployerSignupRequest;
import com.TalentManagement.dto.response.EmployerSignupResponse;


public interface EmployerService {
    EmployerSignupResponse signupEmployer(EmployerSignupRequest request);
    boolean loginEmployer(EmployerLoginRequest email, EmployerLoginRequest password);
    boolean logoutEmployer(EmployerLogoutRequest email, EmployerLogoutRequest password);

}
