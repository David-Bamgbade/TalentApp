package com.TalentManagement.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.TalentManagement.data.model.Employer;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends MongoRepository<Employer, String> {
    Employer findByEmail(String email);
    Employer findByEmailAndPassword(String email, String password);

}
