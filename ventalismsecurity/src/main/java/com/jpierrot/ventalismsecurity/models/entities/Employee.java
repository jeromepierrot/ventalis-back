package com.jpierrot.ventalismsecurity.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * TODO : Employee entity class for 'Employee' and 'Admin' accounts
 * TODO : Only the 'Role' is different between 'Employee' and 'Admin' accounts
 * Extends 'GenericUser' abstract class and implements 'UserDetails' interface (from Spring security)
 */
@SuperBuilder
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("Employee")
public class Employee extends GenericUser {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "regcode", referencedColumnName = "id")
    private RegistrationCode regcodeId;

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adviserId")
    private List<User> users;*/
}
