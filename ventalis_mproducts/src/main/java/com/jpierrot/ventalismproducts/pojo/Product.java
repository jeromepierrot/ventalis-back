package com.jpierrot.ventalismproducts.pojo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    private String label;

    @Builder.Default
    private String description = "";
    private Float unitPriceHt;
    @Builder.Default
    private Integer minOrderQuantity = 1000;
    @Builder.Default
    private String imageResourceUrl = "";

    @Builder.Default
    private Boolean isVisible = false;

    @Override
    public String toString(){
        return "{" +
                "id=" + id +
                ", category=" + category +
                ", label=" + label +
                ", unitPriceHT=" + unitPriceHt +
                ", minOrderQuantity=" + unitPriceHt +
                '}';
    }
}
