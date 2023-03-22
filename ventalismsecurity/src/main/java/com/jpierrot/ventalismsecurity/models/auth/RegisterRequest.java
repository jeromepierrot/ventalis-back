package com.jpierrot.ventalismsecurity.models.auth;

import com.jpierrot.ventalismsecurity.models.Roles;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
//    private String company; // TODO: for testing first to be removed later
    private String lastname;
    private String firstname;
    private String email; /* email = login (= username for UserDetails interface */
    private String password; /* password must have 8 char, incl. 1 MAJ, 1 min, 1 number, 1 special char */
//    private Roles role; /* role MUST be ADMIN or EMPLOYEE */
}
