package com.TalentManagement.dto.response;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployerSignupResponse {
    private String message;
    private String id;
}
