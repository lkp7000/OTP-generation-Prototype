package com.example.EmailPrototype.Repository;

import com.example.EmailPrototype.Entity.EmailPrototypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmailPrototypeRepo extends JpaRepository<EmailPrototypeEntity,Long> {


}
