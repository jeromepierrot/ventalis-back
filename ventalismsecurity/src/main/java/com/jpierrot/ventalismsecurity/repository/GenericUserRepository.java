package com.jpierrot.ventalismsecurity.repository;

import com.jpierrot.ventalismsecurity.models.GenericUser;
import com.jpierrot.ventalismsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenericUserRepository extends JpaRepository<GenericUser, Long> {
    Optional<GenericUser> findByEmail(String email);
}
