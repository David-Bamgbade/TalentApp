package com.TalentManagement.service;

import com.TalentManagement.dto.request.EmployerAdRequest;
import com.TalentManagement.dto.request.EmployerEmailRequest;
import com.TalentManagement.dto.response.EmployerAdResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployerMarketServiceImplTest {

    @Autowired
    private EmployerMarketService employerMarketService;

    @Test
    public void employerToCreateJobAdd() {
        EmployerAdRequest request = new EmployerAdRequest();
        EmployerEmailRequest emailRequest = new EmployerEmailRequest();
        emailRequest.setEmail("victorkelvin@gmail.com");
        request.setSkillDescription("Must know java");
        request.setPayForWork(100);
        request.setSkillLevel("intermediate");
        request.setSkillName("Programmer");
        request.setEducationBackground("b.s.c in computer science is a plus");
        request.setJobResponsibility("Will code an app");
        EmployerAdResponse response = employerMarketService.jobAdd(emailRequest, request);
        assertEquals("Successfully added job alert", response.getMessage());
    }

}