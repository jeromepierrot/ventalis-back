package com.jpierrot.ventalismsecurity.models.auth;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@RequiredArgsConstructor
public class AdminRegisterRequest extends EmployeeRegisterRequest {
}
