package com.jpierrot.ventalismsecurity.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Mapped superclass that is sharing all common 'User', 'Employee' and 'Admin' attributes and static methods
 */
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role_type")
@DiscriminatorValue("GENERIC")
public class GenericUser implements UserDetails {
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
    @Column(name = "email", unique = true)
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


    /* Implemented methods from UserDetails */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRole().toString()));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return getIsEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return getIsEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return getIsEnabled();
    }

    @Override
    public boolean isEnabled() {
        return (isAccountNonExpired() && isAccountNonLocked());
    }
}
