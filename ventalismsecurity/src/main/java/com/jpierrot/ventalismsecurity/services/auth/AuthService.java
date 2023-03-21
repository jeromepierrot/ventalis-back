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
    public AuthResponse register(RegisterRequest request) {
        // TODO : add needed field according to User
        var user = User.builder()
                .company(request.getCompany())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER) /* forces 'USER' role to prevent any privilege elevation */
                .build();

        //Employee adviser;

        /*switch (user.getRole()) {
            case USER -> {
                adviser = employeeRepository.findById(1L).orElse(null); // TODO: test value to be changed by a request to find the right adviser
                user.setCompany(request.getCompany());
                // TODO : add code to attribute a adviser (=employee) to the user
                // TODO: find another default value other than NULL
                user.setAdviserId(adviser);
                user.setIsEnabled(true);
                userRepository.save(user);
            }
            default -> {
                *//* if the role is not 'USER',
                   role is changed to 'UNAUTHORIZED' + account is disabled, then saved into User Database to prevent further auth attempts *//*
                user.setRole(Roles.UNAUTHORIZED);
                user.setIsEnabled(false);
                userRepository.save(user);
            }
        }*/

        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * method to register an Employee or an Administrator, depending on the chosen role
     * This method should only be called from the Administrator space
     * @param employeeRequest 'Employee' (or 'Administrator') registration request only (not for standard 'User' / clients)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(EmployeeRegisterRequest employeeRequest) {
        // TODO : add needed field according to User + check if an 'AdminRegisterRequest' method is required (should NOT)
        var user = GenericUser.builder()
                .firstname(employeeRequest.getFirstname())
                .lastname(employeeRequest.getLastname())
                .email(employeeRequest.getEmail())
                .password(passwordEncoder.encode(employeeRequest.getPassword()))
                .role(Roles.EMPLOYEE) /* TODO: should be 'ADMIN' or 'EMPLOYEE' but not 'USER'*/
                .build();

        Employee newEmployee = (Employee) user;
        Admin newAdmin = (Admin) user;
        User newUser = (User) user;

        switch (user.getRole()) {
            case EMPLOYEE -> {
                user.setIsEnabled(true);
//                newEmployee = (Employee) user;
                employeeRepository.save(newEmployee);
            }
            case ADMIN -> {
                user.setIsEnabled(true);

                adminRepository.save(newAdmin);
            }
            default -> {
                /* if the role is not 'EMPLOYEE' or 'ADMIN',
                   role is changed to 'UNAUTHORIZED' + account is disabled, then saved into User Database  */
                user.setRole(Roles.UNAUTHORIZED);
                user.setIsEnabled(false);
                newUser = (User) user;
                userRepository.save(user);
            }
        }

        var jwtToken = jwtService.generateToken(newEmployee);

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
