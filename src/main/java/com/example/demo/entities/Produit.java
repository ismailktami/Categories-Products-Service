package com.example.demo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @AllArgsConstructor @NoArgsConstructor  @Getter  @Setter
public class Produit {
    @Id
    private String id;
    private String nom;
    private double price;

    @DBRef
    private Category category;
}
