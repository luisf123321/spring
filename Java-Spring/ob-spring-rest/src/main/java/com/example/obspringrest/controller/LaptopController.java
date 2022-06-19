package com.example.obspringrest.controller;

import com.example.obspringrest.entities.Laptop;
import com.example.obspringrest.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    private LaptopRepository laptopRepository;

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







}
