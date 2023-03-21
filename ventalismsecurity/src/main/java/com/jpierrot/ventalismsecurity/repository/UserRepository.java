package com.jpierrot.ventalismsecurity.repository;

import com.jpierrot.ventalismsecurity.models.GenericUser;
import com.jpierrot.ventalismsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<GenericUser, Long> {
    Optional<User> findByEmail(String email);
}
