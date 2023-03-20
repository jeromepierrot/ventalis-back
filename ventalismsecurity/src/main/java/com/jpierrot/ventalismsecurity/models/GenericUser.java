package com.jpierrot.ventalismsecurity.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass // 1 Inheritance Strategy amongst 4
/*@Inheritance(strategy = InheritanceType.JOINED)
public class GenericUser implements UserDetails {*/
public class GenericUser {
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

    /******* static Methods ******/
    public static String autoGeneratePassword() {
        String randomPassword = "A23rty1!"; // TODO : auto-generate a password of minLength=8 characters, with 1 Maj char, 1 min char, 1 number, 1 special char
        return randomPassword;
    }
}
