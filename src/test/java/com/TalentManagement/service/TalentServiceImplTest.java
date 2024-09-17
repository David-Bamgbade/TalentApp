package com.TalentManagement.service;

import com.TalentManagement.dto.request.*;
import com.TalentManagement.dto.response.TalentSignupResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = TalentServiceImpl.class)
class TalentServiceImplTest {

    @Autowired
    private TalentService talentService;

    @Test
    public void testToSignUpTalent() {
        TalentSignupRequest request = new TalentSignupRequest();
        request.setFirstName("David");
        request.setLastName("Bamgbade");
        request.setEmail("davidbamgbade@gmail.com");
        request.setPhoneNumber("08169468242");
        request.setPassword("password");
        request.setAddress("main-street");
        request.setSkills("Software Engineering");
        TalentSignupResponse response = talentService.signupTalent(request);
        response.setMessage("Success");
        assertEquals(response.getMessage(), "Success");
    }


    @Test
    public void testTalentCanLogout(){
        TalentLogoutRequest request = new TalentLogoutRequest();
        request.setEmail("davidbamgbade@gmail.com");
        request.setPassword("password");
        assertTrue(talentService.logoutTalent(request, request));
    }








}