package com.jpierrot.ventalismsecurity.models.auth;

import com.jpierrot.ventalismsecurity.models.Roles;
import lombok.*;

/**
 * stores any 'User' registration request from REST API
 * Note :
 * 'User' = one client of Ventalis. It must only be registered as role = 'USER'
 * -- It is NOT a 'Generic' User --
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest extends RegisterRequest {
    private String company;
}

