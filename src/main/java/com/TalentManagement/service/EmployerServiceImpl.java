package com.TalentManagement.service;

import com.TalentManagement.data.model.Employer;
import com.TalentManagement.data.repositories.EmployerRepo;
import com.TalentManagement.dto.request.*;
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

    public EmployerLoginResponse loginEmployer(EmployerLoginRequest email, EmployerLoginRequest password ) {
        Employer employer = employerRepo.findByEmailAndPassword(validateEmail(email.getEmail()).toLowerCase(), validatePassword(password.getPassword()).toLowerCase());

          if(employer != null) {
              employer.setLoggedIn(true);
              employerRepo.save(employer);
          }
            else {
                   throw new IllegalArgumentException("invalid email or password");
               }

            EmployerLoginResponse response = new EmployerLoginResponse();
            response.setLoginStatus(true);

            return response;
    }

    public EmployerLogoutResponse logoutEmployer(EmployerLogoutRequest email, EmployerLogoutRequest password) {
        Employer employer = employerRepo.findByEmailAndPassword(validateEmail(email.getEmail()).toLowerCase(), validatePassword(password.getPassword()).toLowerCase());

        if(employer != null) {
            employer.setLoggedIn(false);
            employerRepo.save(employer);
        }
        else {
            throw new IllegalArgumentException("invalid email or password");
        }
        EmployerLogoutResponse response = new EmployerLogoutResponse();
        response.setLoggedInStatus(false);
        return response;
    }

    public EmployerEditNameResponse editName(EmployerEmailRequest email, EmployerEditNameRequest request ) {
        Employer employer = employerRepo.findByEmail(email.getEmail());

        if(employer.isLoggedIn()){
            employer.setFirstName(validateFirstName(request.getEmployerFirstName()));
            employer.setLastName(validateLastName(request.getEmployerLastName()));
            employerRepo.save(employer);
            EmployerEditNameResponse response = new EmployerEditNameResponse();
            response.setMessage("Successfully edited name");
            return response;
        }
        else {
            throw new IllegalArgumentException("invalid email or password must be logged in");
        }
    }

    public EmployerEditEmailResponse editEmail(EmployerEmailRequest oldEmail, EmployerEditEmailRequest newEmail ) {
       Employer employer = employerRepo.findByEmail(validateEmail(oldEmail.getEmail()).toLowerCase());
       if(employer.isLoggedIn()) {
           employer.setEmail(validateEmail(newEmail.getNewEmail().toLowerCase()));
           employerRepo.save(employer);
       }

       else {
           throw new IllegalArgumentException("invalid email or password must be logged in");
       }
       EmployerEditEmailResponse response = new EmployerEditEmailResponse();
       response.setMessage("Successfully edited email");
       return response;
    }

    public EmployerEditPasswordResponse editPassword(EmployerEmailAndPasswordRequest request, EmployerEditPasswordRequest newPassword ){
        Employer employer = employerRepo.findByEmailAndPassword(validateEmail(request.getEmployerEmail()).toLowerCase(), validatePassword(request.getEmployerPassword()).toLowerCase());
        if(employer.isLoggedIn()) {
            employer.setPassword(validatePassword(newPassword.getNewPassword()));
            employerRepo.save(employer);
        }
        else{
            throw new IllegalArgumentException("invalid email or password must be logged in");
        }
        EmployerEditPasswordResponse response = new EmployerEditPasswordResponse();
        response.setMessage("Successfully edited password");
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
