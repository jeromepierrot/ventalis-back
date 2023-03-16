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

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date createdDate = new Date(System.currentTimeMillis());

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date modifiedDate = new Date(System.currentTimeMillis());

    @Override
    public String toString(){
        return "{" +
                "id=" + id +
                ", category=" + category +
                ", label=" + label +
                ", unitPriceHT=" + unitPriceHt +
                ", minOrderQuantity=" + unitPriceHt +
                ", creationDate=" + createdDate +
                ", modificationDate=" + modifiedDate +
                '}';
    }
}
