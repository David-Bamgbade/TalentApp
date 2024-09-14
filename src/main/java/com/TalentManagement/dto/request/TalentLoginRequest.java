package com.TalentManagement.dto.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class TalentLoginRequest {
    private String email;
    private String password;
}
