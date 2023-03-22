package com.jpierrot.ventalismsecurity.services.auth;

import com.jpierrot.ventalismsecurity.models.*;
import com.jpierrot.ventalismsecurity.models.auth.*;
import com.jpierrot.ventalismsecurity.repository.AdminRepository;
import com.jpierrot.ventalismsecurity.repository.EmployeeRepository;
import com.jpierrot.ventalismsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService ;
    private final AuthenticationManager authenticationManager;


    /**
     * Standard method to register one 'User' (= client)
     * This method should not be called to register an 'Employee' or an 'Admin'
     * Otherwise, role will not be granted correctly
     * @param request 'User' registration request only (not Employee nor Admin)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(UserRegisterRequest request) {
        // TODO : add needed field according to User
        var user = User.builder()
                .company(request.getCompany())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER) /* forces 'USER' role to prevent any privilege elevation */
                .isEnabled(true)
                .build();

                // TODO: allocate one adviser for testing but should be modified by finding the right adviser
        employeeRepository.findById(1L).ifPresent(adviser -> {
                    user.setAdviserId(adviser);
                });

        /* insert into database */
        userRepository.save(user);

        /* generate JWT */
/*
        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", Roles.USER.name());
        var jwtToken = jwtService.generateToken(extraClaims, user);
*/
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Standard method to register one 'User' (= client)
     * This method should not be called to register an 'Employee' or an 'Admin'
     * Otherwise, role will not be granted correctly
     * @param request 'User' registration request only (not Employee nor Admin)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(EmployeeRegisterRequest request) {
        // TODO : add needed field according to User
        var employee = Employee.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.EMPLOYEE) /* forces 'EMPLOYEE' role to prevent any privilege elevation */
                .build();

        /* insert into database */
        employeeRepository.save(employee);

        /* generate JWT */
        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", Roles.EMPLOYEE.name());
        var jwtToken = jwtService.generateToken(extraClaims, employee);


        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }


    /**
     * // TODO: dev in progress, only authenticating User / need to implement Employee and Admin
     * @param request to authenticate any 'User', 'Employee' or 'Admin'
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
