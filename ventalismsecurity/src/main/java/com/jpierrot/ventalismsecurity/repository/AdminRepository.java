package com.jpierrot.ventalismsecurity.repository;

import com.jpierrot.ventalismsecurity.models.GenericUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<GenericUser, Long> {
}
