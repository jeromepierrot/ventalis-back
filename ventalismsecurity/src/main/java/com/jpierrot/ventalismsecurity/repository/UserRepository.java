package com.jpierrot.ventalismsecurity.repository;

import com.jpierrot.ventalismsecurity.models.Employee;
import com.jpierrot.ventalismsecurity.models.GenericUser;
import com.jpierrot.ventalismsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<Employee>findAdviserById(Long id);
}
