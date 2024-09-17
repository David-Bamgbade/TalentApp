package com.TalentManagement.service;

import com.TalentManagement.dto.request.*;
import com.TalentManagement.dto.response.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
        EmployerLoginResponse response = new EmployerLoginResponse();
        employerService.loginEmployer(request, request);
        assertTrue(response.isLoginStatus());
    }

    @Test
    public void testEmployerLogout() {
        EmployerLogoutRequest request = new EmployerLogoutRequest();
        request.setEmail("david@gmail.com");
        request.setPassword("david");
        EmployerLogoutResponse response = new EmployerLogoutResponse();
        employerService.logoutEmployer(request, request);
        assertFalse(response.isLoggedInStatus());
    }

    @Test
    public void testEmployerCanEditName(){
        EmployerEditNameRequest request = new EmployerEditNameRequest();
        EmployerEmailRequest request1 = new EmployerEmailRequest();
        request1.setEmail("victorkelvin@gmail.com");
        request.setEmployerFirstName("duke");
        request.setEmployerLastName("donald");
        employerService.editName(request1, request);
        EmployerEditNameResponse response = new EmployerEditNameResponse();
        response.setMessage("Successfully edited name");
        assertEquals("Successfully edited name", response.getMessage() );
    }

    @Test
    public void testThatEmployerCanEditEmailAddress(){
        EmployerEmailRequest request = new EmployerEmailRequest();
        request.setEmail("victorkelvin@gmail.com");
        EmployerEditEmailRequest request1 = new EmployerEditEmailRequest();
        request1.setNewEmail("victor@gmail.com");
        employerService.editEmail(request,request1);
        EmployerEditEmailResponse response = new EmployerEditEmailResponse();
        response.setMessage("Successfully edited email address");
        assertEquals("Successfully edited email address", response.getMessage() );
    }

    @Test
    public void testThatEmployerCanEditPassword(){
        EmployerEmailAndPasswordRequest request = new EmployerEmailAndPasswordRequest();
        request.setEmployerEmail("victor@gmail.com");
        request.setEmployerPassword("password1");
        EmployerEditPasswordRequest request1 = new EmployerEditPasswordRequest();
        request1.setNewPassword("password2");
        employerService.editPassword(request, request1);
        EmployerEditPasswordResponse response = new EmployerEditPasswordResponse();
        response.setMessage("Successfully edited password");
        assertEquals("Successfully edited password", response.getMessage() );
    }


}