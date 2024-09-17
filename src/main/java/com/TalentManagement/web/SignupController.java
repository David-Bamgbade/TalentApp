package com.TalentManagement.web;

import com.TalentManagement.dto.request.EmployerLoginRequest;
import com.TalentManagement.dto.request.EmployerSignupRequest;
import com.TalentManagement.dto.response.EmployerLoginResponse;
import com.TalentManagement.dto.response.EmployerSignupResponse;
import com.TalentManagement.service.EmployerMarketService;
import com.TalentManagement.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/userSignup")
@RestController
public class SignupController {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private EmployerMarketService employerMarketService;

    @PostMapping("/signup")
    public ResponseEntity <?> signup(@RequestBody EmployerSignupRequest request) {
        try{
            EmployerSignupResponse response = employerService.signupEmployer(request);
            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @PatchMapping("/login")
    public ResponseEntity <?> login(@RequestBody EmployerLoginRequest request1, EmployerLoginRequest request2) {
        try{
            EmployerLoginResponse response = employerService.loginEmployer(request1, request2);
            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }







}
