package com.TalentManagement.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployerMarket {
    private String email;
    private String password;
    private String skillLevelLookingFor;
    private String skillName;
    private String skillDescription;
    private String skillImage;
    private long payForWork;
    private String educationBackground;
    private String jobResponsibility;
}
