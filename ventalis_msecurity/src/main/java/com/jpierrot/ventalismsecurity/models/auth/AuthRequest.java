package com.jpierrot.ventalismsecurity.models.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Stores any authentication request from REST API
 * this request will check if the user already exists into the database
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String email; /* email = login = username */
    private String password; /* password must have 8 char, incl. 1 MAJ, 1 min, 1 number, 1 special char */
}
