package com.TalentManagement.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Employer {
    @Id
    private String id;
    private Employer employer;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String companyDetails;
    private String password;
    private boolean isLoggedIn;

    @DBRef
    List<Talent> listOfTalent = new ArrayList<Talent>();
}
