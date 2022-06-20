package com.example.obspringrest.controller;

import com.example.obspringrest.entities.Laptop;
import com.example.obspringrest.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    private LaptopRepository laptopRepository;

    private final Logger log = LoggerFactory.getLogger(Laptop.class);

    @GetMapping("laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @PostMapping("laptops")
    public Laptop create(@RequestBody Laptop laptop){

        Laptop laptopOpt =  laptopRepository.save(laptop);
       return laptopOpt;

    }

    @GetMapping("laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){

        Optional<Laptop> laptopOptional = laptopRepository.findById(id);

        if(laptopOptional.isPresent()){
            return ResponseEntity.ok(laptopOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

        if (laptop.getId() == null) {
            log.warn("try ing to update book no exist");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/laptop/{id}")
    @ApiIgnore
    public ResponseEntity<Laptop> deleteBook(@PathVariable Long id) {
        if (!laptopRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/laptops")
    @ApiIgnore
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
