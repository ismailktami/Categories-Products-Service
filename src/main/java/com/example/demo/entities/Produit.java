package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @AllArgsConstructor @NoArgsConstructor  @Getter  @Setter
public class Produit {
    @Id
    @Generated
    private String id;
    private String nom;
    private double price;

    @DBRef
    @JsonIgnore
    private Category category;
}
