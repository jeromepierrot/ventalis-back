package com.jpierrot.ventalismsecurity.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * TODO : Employee entity class for 'Employee' and 'Admin' accounts
 * TODO : Only the 'Role' is different between 'Employee' and 'Admin' accounts
 * Extends 'GenericUser' abstract class and implements 'UserDetails' interface (from Spring security)
 */
@SuperBuilder //required when using superclass
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(
        name="employees",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"email","registration_code"})
)
public class Employee extends GenericUser implements UserDetails {
//    @Builder.Default
    @Column(name = "registration_code", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long registrationCode;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(super.getRole().toString()));
    }

    @Override
    public String getPassword() {
        return super.getPassword(); // explicit declaration to show the inherited 'getPassword()' method from UserDetails interface
    }

    @Override
    public String getUsername() {
        return super.getEmail(); // UserDetails interface calls 'getUsername()' to get the account name => here login=email
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.getIsEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.getIsEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // TODO: return true for starting/testing should be implemented later.
    }

    @Override
    public boolean isEnabled() {
        return (isAccountNonExpired() && isAccountNonLocked());
    }
}
