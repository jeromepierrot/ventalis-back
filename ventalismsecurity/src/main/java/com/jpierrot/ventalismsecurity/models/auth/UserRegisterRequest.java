package com.jpierrot.ventalismsecurity.models.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * stores any 'User' registration request from REST API
 * Note :
 * 'User' = one client of Ventalis. It must only be registered as role = 'USER'
 * -- It is NOT a 'Generic' User --
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    private String company; /* required */
    private String lastname; /* required */
    private String firstname; /* optional */
    private String email; /* email = login (= username for UserDetails interface */
    private String password; /* password must have 8 char, incl. 1 MAJ, 1 min, 1 number, 1 special char */
}

