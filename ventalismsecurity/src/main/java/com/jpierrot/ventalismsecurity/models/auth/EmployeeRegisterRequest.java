package com.jpierrot.ventalismsecurity.models.auth;

import com.jpierrot.ventalismsecurity.models.Roles;
import lombok.*;

/**
 * Stores any 'Employee' registration request from REST API
 * It is used for both ADMIN and EMPLOYEE registration request
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterRequest extends RegisterRequest {

}

