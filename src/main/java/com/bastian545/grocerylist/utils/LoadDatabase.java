package com.bastian545.grocerylist.utils;

import com.bastian545.grocerylist.model.Item;
import com.bastian545.grocerylist.repo.ItemRepo;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase (ItemRepo itemRepo){
        return args -> {
            log.info("Preloading " + itemRepo.save(new Item("Queso",3,"nada")));
            log.info("Preloading " + itemRepo.save(new Item("Sopa",1,"de carne")));
            log.info("Preloading " + itemRepo.save(new Item("Salsa de Tomate",12,"Merkat")));
            log.info("Preloading " + itemRepo.save(new Item("Bebida",0,"")));
        };
    }

}
