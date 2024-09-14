//package com.TalentManagement.service;
//
//import com.TalentManagement.data.repositories.EmployerRepo;
//import com.TalentManagement.dto.request.EmployerAdRequest;
//import com.TalentManagement.dto.request.EmployerEmailRequest;
//import com.TalentManagement.dto.response.EmployerAdResponse;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ContextConfiguration(classes = EmployerMarketServiceImpl.class)
//class EmployerMarketServiceImplTest {
//
//    @Autowired
//    private EmployerMarketService employerMarketService;
//
//    private EmployerRepo employerRepo;
//
//    @Test
//    public void employerToCreateJobAdd() {
//        EmployerAdRequest request = new EmployerAdRequest();
//        EmployerEmailRequest emailRequest = new EmployerEmailRequest();
//        emailRequest.setEmail("victorkelvin@gmail.com");
//        request.setSkillDescription("Must know java");
//        request.setPayForWork(100);
//        request.setSkillLevel("intermediate");
//        request.setSkillLookingFor("Software Engineering");
//        request.setEducationBackground("b.s.c in computer science is a plus");
//        EmployerAdResponse response = employerMarketService.jobAdd(emailRequest, request);
//        assertEquals("Advert added successfully", response.getMessage());
//    }
//
//}