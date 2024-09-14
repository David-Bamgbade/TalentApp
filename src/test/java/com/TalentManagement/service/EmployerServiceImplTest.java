package com.TalentManagement.service;

import com.TalentManagement.dto.request.EmployerLoginRequest;
import com.TalentManagement.dto.request.EmployerLogoutRequest;
import com.TalentManagement.dto.request.EmployerSignupRequest;
import com.TalentManagement.dto.response.EmployerSignupResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployerServiceImplTest {

    @Autowired
   private  EmployerService employerService;

    @Test
    public void testEmployerSignup() {
        EmployerSignupRequest request = new EmployerSignupRequest();
        request.setFirstName("Victor");
        request.setLastName("kelvin");
        request.setEmail("victorKelvin@gmail.com");
        request.setPhoneNumber("08169468223");
        request.setPassword("password1");
        request.setAddress("mains-place");
        request.setCompanyDetails("Software Company");
        EmployerSignupResponse response = employerService.signupEmployer(request);
        response.setMessage("Successfully signed up");
        assertEquals(response.getMessage(), "Successfully signed up");
    }

    @Test
    public void testEmployerLogin() {
        EmployerLoginRequest request = new EmployerLoginRequest();
        request.setEmail("victorkelvin@gmail.com");
        request.setPassword("password1");
        assertTrue(employerService.loginEmployer(request, request));
    }

    @Test
    public void testEmployerLogout() {
        EmployerLogoutRequest request = new EmployerLogoutRequest();
        request.setEmail("victorkelvin@gmail.com");
        request.setPassword("password1");
        assertFalse(employerService.logoutEmployer(request, request));
    }


}