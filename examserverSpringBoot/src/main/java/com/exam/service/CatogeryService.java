package com.exam.service;

import com.exam.entity.exam.Catogery;

import java.util.Set;

public interface CatogeryService {

    public Catogery addCatogery(Catogery catogery);
    public Set<Catogery> getAllCatogery();
    public Catogery getCatogeryById(Long cId);
    public Catogery updateCatogery(Catogery catogery);
    public void deleteCatogery(Long cId);
}
