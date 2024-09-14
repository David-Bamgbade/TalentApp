package com.TalentManagement.dto.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployerEmailRequest {
    private String email;
}
