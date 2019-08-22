package com.example.demo.web;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
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




}
