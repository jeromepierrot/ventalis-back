package com.jpierrot.ventalismsecurity.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * User entity class for 'User' = clients
 * Extends 'GenericUser' abstract class and implements 'UserDetails' interface (from Spring security)
 */
@SuperBuilder //required when using superclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name="users",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"company"})
)
public class User extends GenericUser implements UserDetails {

    private String company;

    @ManyToOne()
    @JoinColumn(name = "adviser_id")
    private Employee adviserId;

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
