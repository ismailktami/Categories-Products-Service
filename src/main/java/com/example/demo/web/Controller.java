package com.example.demo.web;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/Allproduits/{id}")
    public HashMap<String,List<Produit>> getAllProduit(@PathVariable("id") String id){

         HashMap<String,List<Produit>> listes= new HashMap<String,List<Produit>>();
         listes.put("Produits", (List<Produit>) categoryRepository.findById(id).get().getProduis());
         return listes;
    }

    @GetMapping("/Allcategories")
    public HashMap<String,List<Category>> getAllcategories(){
        HashMap<String,List<Category>> listes= new HashMap<String,List<Category>>();
        listes.put("Categories",categoryRepository.findAll());
        return listes;
    }
    @PutMapping("/categories")
    public Category updateCategorie(@RequestBody Category category){
       return  categoryRepository.save(category);
    }
    @DeleteMapping("/categories/{id}")
    public Category deleteCategory(@PathVariable("id") String id){
        Category c=categoryRepository.findById(id).get();
        categoryRepository.delete(c);
        return c;
    }

    @PostMapping("categories")
    public Category addCategory(@RequestBody Category c){
        return categoryRepository.save(c);
    }


    @PostMapping("categories/{id}/addProduit")
    public Produit addProduitToCategory(@PathVariable("id") String id,@RequestBody Produit p){
        System.err.println(p.getNom());
        System.err.println(p.getPrice());
        p.setId(Math.random()*100+" ");
        Category c=categoryRepository.findById(id).get();
        p.setCategory(c);
        c.getProduis().add(p);
        categoryRepository.save(c);
        produitRepository.save(p);
        return p;
    }
   @PostMapping("categories/{id}/editProduit")
    public Produit modifyProduitToCategory(@PathVariable("id") String id,@RequestBody Produit p){
        //produitRepository.findByCategory(id);

        return   produitRepository.save(p);

    }

    @DeleteMapping("categories/{id}/deleteproduit/{idProduit}")
    public Produit deleteProduitToCategory(@PathVariable("id") String id,@PathVariable("idProduit") String p){


        /*
        c.getProduis().removeIf(
                produit->(
                        produit.getId().equals(p.getId())
        ));
        categoryRepository.save(c);
        produitRepository.delete(p);
           return p;

  */

    return null;
    }



}
