package com.TalentManagement.service;

import com.TalentManagement.dto.request.*;
import com.TalentManagement.dto.response.*;


public interface EmployerService {
    EmployerSignupResponse signupEmployer(EmployerSignupRequest request);
    EmployerLoginResponse loginEmployer(EmployerLoginRequest email, EmployerLoginRequest password);
    EmployerLogoutResponse logoutEmployer(EmployerLogoutRequest email, EmployerLogoutRequest password);
    EmployerEditNameResponse editName(EmployerEmailRequest emailRequest, EmployerEditNameRequest request );
    EmployerEditEmailResponse editEmail(EmployerEmailRequest email, EmployerEditEmailRequest request );
    EmployerEditPasswordResponse editPassword(EmployerEmailAndPasswordRequest request, EmployerEditPasswordRequest newPassword );
}
