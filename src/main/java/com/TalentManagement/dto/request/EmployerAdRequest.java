package com.TalentManagement.dto.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployerAdRequest {
    private String skillLevel;
    private String skillName;
    private String skillDescription;
    private String skillImage;
    private long payForWork;
    private String educationBackground;
    private String jobResponsibility;
}
