package com.example.demo.dao;

import com.example.demo.entities.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ProduitRepository extends MongoRepository<Produit,String> {

}
