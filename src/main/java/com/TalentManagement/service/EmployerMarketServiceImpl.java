package com.TalentManagement.service;

import com.TalentManagement.data.model.Employer;
import com.TalentManagement.data.model.EmployerMarket;
import com.TalentManagement.data.repositories.EmployerMarketRepo;
import com.TalentManagement.data.repositories.EmployerRepo;
import com.TalentManagement.dto.request.EmployerAdRequest;
import com.TalentManagement.dto.request.EmployerEmailRequest;
import com.TalentManagement.dto.response.EmployerAdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerMarketServiceImpl implements EmployerMarketService {

    @Autowired
    private  EmployerMarketRepo employerMarketRepo;

    @Autowired
    private EmployerRepo employerRepo;


    @Override
    public EmployerAdResponse jobAdd(EmployerEmailRequest email, EmployerAdRequest request) {
        Employer employer = employerRepo.findByEmail(validateEmail(email.getEmail()).toLowerCase());
        if (employer.isLoggedIn() == true) {
            EmployerMarket market = new EmployerMarket();
            market.setSkillDescription(request.getSkillDescription().toLowerCase());
            market.setSkillName(request.getSkillName().toLowerCase());
            market.setEducationBackground(request.getEducationBackground().toLowerCase());
            market.setPayForWork(request.getPayForWork());
            market.setSkillImage(request.getSkillImage());
            market.setJobResponsibility(request.getJobResponsibility());
            employerMarketRepo.save(market);
        } else {
            throw new IllegalArgumentException("You are not logged in");
        }
        EmployerAdResponse response = new EmployerAdResponse();
        response.setMessage("Successfully added job alert");
        return response;
    }





















    private String validateFirstName(String firstName ){
        if(firstName.contains(" ")){
            throw new IllegalArgumentException("Invalid first name");
        }
        else {
            return firstName;
        }
    }

    private String validateLastName(String lastName){
        if(lastName.contains(" ")){
            throw new IllegalArgumentException("Invalid last name");
        }
        else {
            return lastName;
        }
    }

    private String validateEmail(String email) {
        if(!email.contains("@") || !email.contains(".") || email.contains(" ")){
            throw new IllegalArgumentException("invalid email");
        }
        else{
            return email;
        }

    }

    private String validatePhoneNumber(String phoneNumber){
        long number = Long.parseLong(phoneNumber);
        if(phoneNumber.length() != 11 ||  phoneNumber.contains(" ")){
            throw new IllegalArgumentException("Invalid phone number");
        }
        else{
            return  String.valueOf(number);
        }
    }

    private String validateAddress(String address){
        if(address.contains(" ")){
            throw new IllegalArgumentException("Invalid address");
        }
        else {
            return address;
        }
    }

    private String validatePassword(String password){
        if(password.contains(" ")){
            throw new IllegalArgumentException("Invalid password");
        }
        else {
            return password;
        }
    }



}
