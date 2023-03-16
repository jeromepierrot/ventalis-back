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

    @ManyToOne
    @JoinColumn(name = "id_picture")
    private Picture picture;

    @Builder.Default
    private Boolean isVisible = false;

    // TODO : field type to be determined by registerCode of Employee class
    @Builder.Default
    private String createdBy = "Created by inconnu"; // registerCode of the one employee who has created the product item

    @Builder.Default
    private String modifiedBy = "Modified by not known"; // registerCode of the one employee who has modified the product item

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
                ", label=" + label +
                ", picture=" + picture +
                ", unitPriceHT=" + unitPriceHt +
                ", category=" + category +
                ", minOrderQuantity=" + unitPriceHt +
                ", creationDate=" + createdDate +
                ", modificationDate=" + modifiedDate +
                '}';
    }
}
