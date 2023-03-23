package com.jpierrot.ventalismproducts.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.File;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private File fileContent;

    @Builder.Default
    private Long size = 0L;

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
}
