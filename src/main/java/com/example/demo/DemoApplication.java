package com.example.demo;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication{


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, ProduitRepository produitRepository){
        return  args->{


              // categoryRepository.deleteAll();
              //produitRepository.deleteAll();

               categoryRepository.save(new Category("3","Chimie",new ArrayList<>()));
               categoryRepository.save(new Category("4","Physique",new ArrayList<>()));
                categoryRepository.save(new Category("1","Informatique",new ArrayList<>()));

            Stream.of("P1","P2").forEach(p->{
                    Produit pr=produitRepository.save(new Produit(p,p,Math.random()*100,categoryRepository.findById("3").get()));
                    Category c =categoryRepository.findById("3").get();
                    c.getProduis().add(pr);
                    categoryRepository.save(c);
               });


            Stream.of("P121","P25").forEach(p->{
                Produit pr=produitRepository.save(new Produit(p,p,Math.random()*100,categoryRepository.findById("4").get()));
                Category c =categoryRepository.findById("4").get();
                c.getProduis().add(pr);
                categoryRepository.save(c);
            });
            Stream.of("P4444","P25").forEach(p->{
                Produit pr=produitRepository.save(new Produit(p,p,Math.random()*100,categoryRepository.findById("4").get()));
                Category c =categoryRepository.findById("1").get();
                c.getProduis().add(pr);
                categoryRepository.save(c);
            });

            categoryRepository.findAll().forEach(c->{
                    c.Tostring();
            });
        };

    }



}
