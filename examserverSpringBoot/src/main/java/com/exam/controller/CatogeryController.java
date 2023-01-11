package com.exam.controller;

import com.exam.entity.exam.Catogery;
import com.exam.service.CatogeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CatogeryController {
    @Autowired
    private CatogeryService catogeryService;

    @PostMapping("/")
    public Catogery addCatogery(@RequestBody Catogery catogery){
        return catogeryService.addCatogery(catogery);
    }
    @GetMapping("/")
    public Set<Catogery> getAllCatogery(){
        return catogeryService.getAllCatogery();
    }
    @GetMapping("/{cid}")
    public Catogery getCatogeryById(@PathVariable("cid")Long cid){
        return catogeryService.getCatogeryById(cid);
    }
    @PutMapping("/")
    public Catogery updateCatogery(@RequestBody Catogery catogery){
        return catogeryService.updateCatogery(catogery);
    }
    @DeleteMapping("/{cId}")
    public void deleteCatogeryById(@PathVariable("cId")Long cid){
         catogeryService.deleteCatogery(cid);
    }
}
