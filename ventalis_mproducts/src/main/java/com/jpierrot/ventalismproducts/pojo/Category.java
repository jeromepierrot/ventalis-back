package com.jpierrot.ventalismproducts.pojo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // TODO : Should be unique (-> this constraint is done in MariaDB's side)

    @Builder.Default
    private Boolean isVisible = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date createdDate = new Date(System.currentTimeMillis());

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date modifiedDate = new Date(System.currentTimeMillis());

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", category=" + name +
                '}';
    }
}
