package com.TalentManagement.service;

import com.TalentManagement.data.model.Employer;
import com.TalentManagement.data.repositories.EmployerRepo;
import com.TalentManagement.dto.request.EmployerLoginRequest;
import com.TalentManagement.dto.request.EmployerLogoutRequest;
import com.TalentManagement.dto.request.EmployerSignupRequest;
import com.TalentManagement.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private  EmployerRepo employerRepo;


    public EmployerSignupResponse signupEmployer(EmployerSignupRequest request) {
        if(employerRepo.findByEmail(request.getEmail()) == null) {
            Employer employer = new Employer();
            employer.setFirstName(validateFirstName(request.getFirstName()).toLowerCase());
            employer.setLastName(validateLastName(request.getLastName()).toLowerCase());
            employer.setEmail(validateEmail(request.getEmail().toLowerCase()));
            employer.setPhoneNumber(validatePhoneNumber(request.getPhoneNumber()).toLowerCase());
            employer.setAddress(validateAddress(request.getAddress().toLowerCase()));
            employer.setCompanyDetails(request.getCompanyDetails().toLowerCase());
            employer.setPassword(validatePassword(request.getPassword()).toLowerCase());
            employer.setId(employer.getId());
            employerRepo.save(employer);
            employer.setEmployer(employer);
            EmployerSignupResponse response = new EmployerSignupResponse();
            response.setMessage("Successfully signed up");
            return response;
        }
        else {
         throw new IllegalArgumentException("User already exist");
        }
    }

    public boolean loginEmployer(EmployerLoginRequest email, EmployerLoginRequest password ) {
        Employer employer = employerRepo.findByEmailAndPassword(validateEmail(email.getEmail()).toLowerCase(), validatePassword(password.getPassword()).toLowerCase());

          if(employer != null) {
              employer.setLoggedIn(true);
              employerRepo.save(employer);
          }
            else {
                   throw new IllegalArgumentException("invalid email or password");
               }
            return employer.isLoggedIn();
    }

    public boolean logoutEmployer(EmployerLogoutRequest email, EmployerLogoutRequest password) {
        Employer employer = employerRepo.findByEmailAndPassword(validateEmail(email.getEmail()).toLowerCase(), validatePassword(password.getPassword()).toLowerCase());

        if(employer != null) {
            employer.setLoggedIn(false);
            employerRepo.save(employer);
        }
        else {
            throw new IllegalArgumentException("invalid email or password");
        }
        return employer.isLoggedIn();
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
