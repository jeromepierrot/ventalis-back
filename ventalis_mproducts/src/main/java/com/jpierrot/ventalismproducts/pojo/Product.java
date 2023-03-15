package com.jpierrot.ventalismproducts.pojo;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

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

    private String name;

    @Builder.Default
    private String description = "";
    private Float unitPriceHt;
    @Builder.Default
    private Integer minOrderQuantity = 1000;
    @Builder.Default
    private String imageResourceUrl = "";

    @Builder.Default
    private Boolean isVisible = false;

    // TODO : add creationDate and modificationDate into Database schema
/*
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
*/

    @Override
    public String toString(){
        return "{" +
                "id=" + id +
                ", category=" + category +
                ", label=" + name +
                ", unitPriceHT=" + unitPriceHt +
                ", minOrderQuantity=" + unitPriceHt +
                '}';
    }
}
