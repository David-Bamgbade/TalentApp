package com.TalentManagement.dto.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployerEditNameRequest {
    private String employerFirstName;
    private String employerLastName;
    private String email;
}
