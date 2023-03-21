package com.jpierrot.ventalismsecurity.models.auth;

import com.jpierrot.ventalismsecurity.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Stores any 'Employee' registration request from REST API
 * It is used for both ADMIN and EMPLOYEE registration request
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterRequest {
    private String lastname;
    private String firstname;
    private String email; /* email = login (= username for UserDetails interface */
    private String password; /* password must have 8 char, incl. 1 MAJ, 1 min, 1 number, 1 special char */
    private Roles role; /* tole MUST be ADMIN or EMPLOYEE */
}

