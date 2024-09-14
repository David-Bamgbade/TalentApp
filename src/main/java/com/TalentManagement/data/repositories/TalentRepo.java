package com.TalentManagement.data.repositories;

import com.TalentManagement.data.model.Talent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TalentRepo extends MongoRepository<Talent, String> {
    Talent findByEmail(String email);
    Talent findByEmailAndPassword(String email, String password);

}
