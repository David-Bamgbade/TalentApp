package com.TalentManagement.dto.response;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployerEditNameResponse {
    private String message;

}
