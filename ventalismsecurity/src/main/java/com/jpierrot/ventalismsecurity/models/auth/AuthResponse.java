package com.jpierrot.ventalismsecurity.models.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Stores Authentication response to send to the REST API back.
 * It will send a JWT (token) back to the Front-end if authentification is a success.
 * Otherwise (...) TODO: complete the Javadoc
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String token;
}
