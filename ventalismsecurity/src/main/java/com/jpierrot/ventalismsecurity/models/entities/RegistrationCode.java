package com.jpierrot.ventalismsecurity.models.entities;

import com.jpierrot.ventalismsecurity.models.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "registration_codes")
public class RegistrationCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "regcode", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    Long regcode;

    @OneToOne(mappedBy = "regcodeId")
    private Employee employee;
}
