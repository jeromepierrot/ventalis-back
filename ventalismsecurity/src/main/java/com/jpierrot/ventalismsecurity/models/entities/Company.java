package com.jpierrot.ventalismsecurity.models.entities;

import com.jpierrot.ventalismsecurity.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "companies")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name", nullable = false, unique = true)
    String name;

    @OneToOne(mappedBy = "companyId")
    private User user;
}
