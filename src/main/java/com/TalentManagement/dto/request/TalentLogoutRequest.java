package com.TalentManagement.dto.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TalentLogoutRequest {
    private String email;
    private String password;
}
