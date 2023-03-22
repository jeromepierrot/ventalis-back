package com.jpierrot.ventalismsecurity.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
//    @Builder.Default
    @Column(name = "registration_code", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long registrationCode;

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adviserId")
    private List<User> users;*/
}
