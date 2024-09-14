package com.TalentManagement.service;

import com.TalentManagement.dto.request.TalentLoginRequest;
import com.TalentManagement.dto.request.TalentLogoutRequest;
import com.TalentManagement.dto.request.TalentSignupRequest;
import com.TalentManagement.dto.response.TalentSignupResponse;

public interface TalentService   {
    TalentSignupResponse signupTalent(TalentSignupRequest talentSignupRequest);
    boolean loginTalent(TalentLoginRequest email, TalentLoginRequest password);
    boolean logoutTalent(TalentLogoutRequest talentLogoutRequest, TalentLogoutRequest request);
}
