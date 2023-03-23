package com.jpierrot.ventalismsecurity.services.auth;

import com.jpierrot.ventalismsecurity.models.*;
import com.jpierrot.ventalismsecurity.models.auth.*;
import com.jpierrot.ventalismsecurity.models.entities.Company;
import com.jpierrot.ventalismsecurity.models.entities.RegistrationCode;
import com.jpierrot.ventalismsecurity.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    private final RegistrationCodeRepository registrationCodeRepository;


    /**
     * Standard method to register one 'User' (= client)
     * This method should not be called to register any 'Employee' or 'Admin'
     * Otherwise, role will not be granted correctly
     * @param request 'User' registration request only (not Employee, nor Admin)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(UserRegisterRequest request) {

        /* TODO: add a validation password checker/parser first */

        /* Check if company exists, then add it if not TODO : refactorize as static method  */
        var company = Company.builder()
                .name(request.getCompany())
                .build();

        if (companyRepository.findByName(request.getCompany()).isPresent()) {
            company = companyRepository.findByName(company.getName()).get();
        }

        companyRepository.save(company);

        var adviser = new Employee();

        // TODO: allocate one adviser for testing but should be modified by finding the right adviser
        if (employeeRepository.findById(1L).isPresent()
            /* TODO : && isValidPassword(request.getPassword())*/) {
            adviser = (Employee) employeeRepository.findById(1L).get();
        }

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER) /* forces 'USER' role to prevent any privilege elevation */
                .companyId(company) /* allocate the 'company' we just created above */
                .adviserId(adviser) /* TODO : allocate one 'adviser' we just looked at above */
                .isEnabled(true)
                .build();

        /* insert into database */
        userRepository.save(user);

        /* generate JWT with extra claims */
/*        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", Roles.USER.name());
        var jwtToken = jwtService.generateToken(extraClaims, user);*/

        /* generate JWT WITHOUT extra claims */
        var jwtToken = jwtService.generateToken(user);

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

        /* TODO: add a validation password checker/parser first */

        /* Generate a new random Registration Code  TODO : to refactorize*/
        Long randomCode;
        do {
            randomCode = generateRandomRegistrationCode();
        } while (registrationCodeRepository.findByRegcode(randomCode).isPresent()); /* check if randomRegcode already exist */

        var regcode = RegistrationCode.builder()
                .regcode(randomCode)
                .build();

        /* We only add the regcode into DB only if the email is not registered yet and password respects the rules */
        /* Otherwise, we don't persist it */
        if (genericUserRepository.findByEmail(request.getEmail()).isEmpty()
            /* TODO : && isValidPassword(request.getPassword())*/) {
            registrationCodeRepository.save(regcode);
        }

        var employee = Employee.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.EMPLOYEE) /* forces 'EMPLOYEE' role to prevent any privilege elevation */
                .regcodeId(regcode) /* allocate the regcode we just created above */
                .isEnabled(true)
                .build();

        /* insert the new employee into database, only if any other user have the same email yet */
        employeeRepository.save(employee);


        /* generate JWT with extra claims */
/*        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", employee.getRole());
        var jwtToken = jwtService.generateToken(extraClaims, employee);*/

        /* generate JWT WITHOUT extra claims */
                var jwtToken = jwtService.generateToken(employee);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Standard method to register one 'Administrator' //TODO : could be refactorized using Employee Request
     * This method should not be called to register any 'User' or 'Employee'
     * Otherwise, role will be granted incorrectly
     * @param request 'Admin' registration request only (not User, nor Employee)
     * @return one valid JWT token according to JwtAuthFilter configuration
     */
    public AuthResponse register(AdminRegisterRequest request) {

        /* Generate a new random Registration Code */
        Long randomCode;
        do {
            randomCode = generateRandomRegistrationCode();
        } while (registrationCodeRepository.findByRegcode(randomCode).isPresent()); /* check if randomRegcode already exist */

        var regcode = RegistrationCode.builder()
                .regcode(randomCode)
                .build();

        /* We only add the regcode into DB only if the email is not registered yet */
        /* Otherwise,  */
        if (genericUserRepository.findByEmail(request.getEmail()).isEmpty()) {
            registrationCodeRepository.save(regcode);
        }

        var admin = Admin.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.ADMIN) /* forces 'ADMIN' role to prevent any privilege elevation */
                .regcodeId(regcode)
                .isEnabled(true)
                .build();

        /* insert the new admin into database, only if any other user have the same email yet */
        adminRepository.save(admin);

        /* generate JWT with extra claims*/
/*        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", admin.getRole());
        var jwtToken = jwtService.generateToken(extraClaims, admin);*/

        /* generate JWT WITHOUT extra claims */
        var jwtToken = jwtService.generateToken(admin);

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

        /* generate JWT with extra claims */
/*        Map<String, Object> extraClaims  = new HashMap<>();
        extraClaims.put("roles", user.getRole());
        var jwtToken = jwtService.generateToken(extraClaims, user);*/

        /* generate JWT WITHOUT extra claims */
        var jwtToken = jwtService.generateToken(user);

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
