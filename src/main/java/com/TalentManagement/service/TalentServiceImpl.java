package com.TalentManagement.service;

import com.TalentManagement.data.model.Talent;
import com.TalentManagement.data.repositories.TalentRepo;
import com.TalentManagement.dto.request.TalentLoginRequest;
import com.TalentManagement.dto.request.TalentLogoutRequest;
import com.TalentManagement.dto.request.TalentSignupRequest;
import com.TalentManagement.dto.response.TalentLoginResponse;
import com.TalentManagement.dto.response.TalentLogoutResponse;
import com.TalentManagement.dto.response.TalentSignupResponse;
import org.springframework.stereotype.Service;

@Service
public class TalentServiceImpl implements TalentService {

    private TalentRepo talentRepo;

    @Override
    public TalentSignupResponse signupTalent(TalentSignupRequest talentSignupRequest)  {
        TalentSignupResponse talentSignupResponse = new TalentSignupResponse();
        if (talentRepo.findByEmail(talentSignupRequest.getEmail()) == null) {
            Talent talent = new Talent();
            talent.setFirstName(validateFirstName(talentSignupRequest.getFirstName()).toLowerCase());
            talent.setLastName(validateLastName(talentSignupRequest.getLastName().toLowerCase()));
            talent.setEmail(validateEmail(talentSignupRequest.getEmail().toLowerCase()));
            talent.setPassword(validatePassword(talentSignupRequest.getPassword().toLowerCase()));
            talent.setPhoneNumber(validatePhoneNumber(talentSignupRequest.getPhoneNumber().toLowerCase()));
            talent.setAddress(validateAddress(talentSignupRequest.getAddress().toLowerCase()));
            talent.setSkills(talentSignupRequest.getSkills().toLowerCase());
            talent = talentRepo.save(talent);
            talentSignupResponse.setId(String.valueOf(talent.getId()));
            talentSignupResponse.setMessage("Success");
            return talentSignupResponse;
        }
        else {
         throw new IllegalArgumentException("User Already Exist");
        }
    }


    public boolean logoutTalent(TalentLogoutRequest email, TalentLogoutRequest password) {
        TalentLogoutResponse response = new TalentLogoutResponse();
        if(talentRepo.findByEmailAndPassword(validateEmail(email.getEmail()).toLowerCase(), validatePassword(password.getPassword().toLowerCase())) != null) {
            return response.isLogoutStatus();
        }
        else{
            throw new IllegalArgumentException("Cant Logout Check Email And Password");
        }
    }
    private boolean talentLogin(){
        TalentLoginResponse response = new TalentLoginResponse();
        if(response.isLoggedInStatus()){
            return true;
        }
        else{
            throw new IllegalArgumentException("Not LoggedIn");
        }
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

    private String validateEmail(String email){
        if(email.contains(" ") || !email.contains("@") || !email.contains(".")  ){
            throw new IllegalArgumentException("Invalid email");
        }
        else {
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
