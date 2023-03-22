package com.jpierrot.ventalismsecurity.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Admin entity class for 'Admin' user
 * Extends 'GenericUser' abstract class and implements 'UserDetails' interface (from Spring security)
 */

@SuperBuilder
@RequiredArgsConstructor
@Entity
public class Admin extends Employee {
}
