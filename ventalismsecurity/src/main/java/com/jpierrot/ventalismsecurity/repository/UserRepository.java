package com.jpierrot.ventalismsecurity.repository;

import com.jpierrot.ventalismsecurity.models.Employee;

import java.util.Optional;

public interface UserRepository extends GenericUserRepository {
    Optional<Employee> findAdviserById(Long id);
}
