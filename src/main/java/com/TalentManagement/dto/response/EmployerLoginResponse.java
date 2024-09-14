package com.TalentManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployerLoginResponse {
   private boolean loginStatus = true;
}
