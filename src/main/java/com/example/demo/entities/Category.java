package com.example.demo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
@Data @AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class Category
{
    @Id
    private String id;
    private String name;
    @DBRef
    private Collection<Produit> produis=new ArrayList<>();


    public void Tostring(){
        System.out.println(id+"\t"+name+"\t"+produis.size());
    }


}
