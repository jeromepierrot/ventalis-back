package com.jpierrot.ventalismsecurity.services.auth;

import com.jpierrot.ventalismsecurity.models.*;
import com.jpierrot.ventalismsecurity.models.auth.*;
import com.jpierrot.ventalismsecurity.models.entities.Company;
import com.jpierrot.ventalismsecurity.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final GenericUserRepository genericUserRepository;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService ;
    private final AuthenticationManager authenticationManager;
    private final CompanyRepository companyRepository;


    /**
     * Standard method to register one 'User' (= client)
     * This method should not be called to register any 'Employee' or 'Admin'
     * Otherwise, role will not be granted correctly
     * @param request 'User' registration request only (not Employee, nor Admin)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(UserRegisterRequest request) {

        var company = Company.builder()
                .name(request.getCompany())
                .build();

        if (companyRepository.findByName(request.getCompany()).isPresent()) {
            company = companyRepository.findByName(company.getName()).get();
        }

        companyRepository.save(company);

        var adviser = new Employee();

        // TODO: allocate one adviser for testing but should be modified by finding the right adviser
        if (employeeRepository.findById(1L).isPresent()) {
            adviser = (Employee) employeeRepository.findById(1L).get();
        }

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER) /* forces 'USER' role to prevent any privilege elevation */
                .companyId(company)
                .adviserId(adviser)
                .isEnabled(true)
                .build();

/*        employeeRepository.findById(1L).ifPresent(adviser -> {
                    user.setAdviserId((Employee) adviser);
                });*/

        /* insert into database */
        userRepository.save(user);

        /* generate JWT */
        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", Roles.USER.name());
        var jwtToken = jwtService.generateToken(extraClaims, user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Standard method to register one 'Employee'
     * This method should not be called to register any 'User' or 'Admin'
     * Otherwise, role will be granted incorrectly
     * @param request 'Employee' registration request only (not User, nor Admin)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(EmployeeRegisterRequest request) {
        /* Generate Random registration Code (SHORT UUID Like) */
        Integer randomNumber = new Random(System.currentTimeMillis()).nextInt(99999999);
        Long registrationCode =  randomNumber.longValue();

        var employee = Employee.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.EMPLOYEE) /* forces 'EMPLOYEE' role to prevent any privilege elevation */
                .registrationCode(registrationCode)
                .isEnabled(true)
                .build();

        /* insert into database */
        employeeRepository.save(employee);

        /* generate JWT */
        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", employee.getRole());
        var jwtToken = jwtService.generateToken(extraClaims, employee);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Standard method to register one 'Administrator'
     * This method should not be called to register any 'User' or 'Employee'
     * Otherwise, role will be granted incorrectly
     * @param request 'Admin' registration request only (not User, nor Employee)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(AdminRegisterRequest request) {
        var admin = Admin.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.ADMIN) /* forces 'ADMIN' role to prevent any privilege elevation */
                .registrationCode(generateRandomRegistrationCode())
                .isEnabled(true)
                .build();

        /* insert into database */
        adminRepository.save(admin);

        /* generate JWT */
        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", admin.getRole());
        var jwtToken = jwtService.generateToken(extraClaims, admin);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }


    /**
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
        var user = genericUserRepository.findByEmail(request.getEmail())
                .orElseThrow();

        /* generate JWT */
        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", user.getRole());
        var jwtToken = jwtService.generateToken(extraClaims, user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Generate Random registration Code (SHORT UUID Like)
     * @return one random 8-bytes value (numbers onlu)
     *  */
    public Long generateRandomRegistrationCode() {
        Integer randomNumber = new Random(System.currentTimeMillis()).nextInt(99999999);
        return randomNumber.longValue();
    }
}
