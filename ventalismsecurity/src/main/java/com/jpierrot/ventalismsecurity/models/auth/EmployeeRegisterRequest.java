package com.jpierrot.ventalismsecurity.models.auth;

import com.jpierrot.ventalismsecurity.models.Roles;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Stores any 'Employee' registration request from REST API
 * It is used for both ADMIN and EMPLOYEE registration request
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@RequiredArgsConstructor
public class EmployeeRegisterRequest extends RegisterRequest {

}

