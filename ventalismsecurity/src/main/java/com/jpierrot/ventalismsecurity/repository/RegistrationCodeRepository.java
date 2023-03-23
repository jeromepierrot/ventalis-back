package com.jpierrot.ventalismsecurity.repository;

import com.jpierrot.ventalismsecurity.models.entities.RegistrationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationCodeRepository extends JpaRepository<RegistrationCode, Long> {

    Optional<RegistrationCode> findByRegcode(Long regcode);
}
