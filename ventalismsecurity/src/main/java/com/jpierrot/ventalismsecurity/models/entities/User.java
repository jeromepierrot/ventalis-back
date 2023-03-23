package com.jpierrot.ventalismsecurity.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * User entity class for 'User' = clients
 * Extends 'GenericUser' abstract class and implements 'UserDetails' interface (from Spring security)
 */
@SuperBuilder
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("User")
public class User extends GenericUser {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adviser_id")
    private Employee adviserId;

    public void setAdviserId(Employee adviser) {
        this.adviserId = adviser;
    }
}
