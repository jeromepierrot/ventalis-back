package com.jpierrot.ventalismsecurity.repository;

import com.jpierrot.ventalismsecurity.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// TODO: check if required, should NOT (using EmployeeRepository instead)
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String username);
}
