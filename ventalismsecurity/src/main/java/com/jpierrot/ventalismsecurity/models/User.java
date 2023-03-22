package com.jpierrot.ventalismsecurity.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * User entity class for 'User' = clients
 * Extends 'GenericUser' abstract class and implements 'UserDetails' interface (from Spring security)
 */
@Builder //required when using superclass
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
public class User implements UserDetails {

    private String company;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lastname")
    private String lastname; /*careful : Do Not Use this one as 'Username' in 'getUsername()'*/

    @Builder.Default
    @Column(name = "firstname")
    private String firstname = null; /* not mandatory */

    /* Careful: email here is the login, so it is equivalent to 'username' in UserDetails interface.
    'getUsername()' is its Getter/Setter */
    @Column(name = "email")
    private String email;

    /* Careful: if this attribute is called 'password', getPassword() won't appear but needs to be overridden from UserDetails */
    @Column(name = "password")
    private String password;

    @Column(name = "is_enabled")
    private Boolean isEnabled; // not used yet but need to be implemented to disable accounts if needed

    @Enumerated(EnumType.STRING)
    private Roles role;

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    @Column(name = "created_date")
    private Date createdDate = new Date(System.currentTimeMillis());

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    @Column(name = "modified_date")
    private Date modifiedDate = new Date(System.currentTimeMillis());

    @ManyToOne()
    @JoinColumn(name = "adviser_id")
    private Employee adviserId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRole().toString()));
    }

    @Override
    public String getPassword() {
        return password; // explicit declaration to show the inherited 'getPassword()' method from UserDetails interface
    }

    @Override
    public String getUsername() {
        return getEmail(); // UserDetails interface calls 'getUsername()' to get the account name => here login=email
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // TODO: return true for starting/testing should be implemented later.
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
