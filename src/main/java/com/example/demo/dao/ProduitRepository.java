package com.example.demo.dao;

import com.example.demo.entities.Category;
import com.example.demo.entities.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ProduitRepository extends MongoRepository<Produit,String> , QuerydslPredicateExecutor<Produit> {

    @Query(value = "{'category._id':?0,_id:?1}")
    Produit findByCategory( String id,String id2);

}
