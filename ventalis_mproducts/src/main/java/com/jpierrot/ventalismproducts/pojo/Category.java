package com.jpierrot.ventalismproducts.pojo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Builder.Default
    private Boolean isVisible = false;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", category=" + name +
                '}';
    }
}
