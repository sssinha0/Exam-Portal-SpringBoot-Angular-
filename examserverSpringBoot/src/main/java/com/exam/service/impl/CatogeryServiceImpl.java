package com.exam.service.impl;

import com.exam.entity.exam.Catogery;
import com.exam.repo.CatogeryRepository;
import com.exam.service.CatogeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class CatogeryServiceImpl implements CatogeryService {
    @Autowired
    private CatogeryRepository catogeryRepository;
    @Override
    public Catogery addCatogery(Catogery catogery) {
        return catogeryRepository.save(catogery);
    }

    @Override
    public Set<Catogery> getAllCatogery() {
        return new LinkedHashSet<>(catogeryRepository.findAll());
    }

    @Override
    public Catogery getCatogeryById(Long cId) {
        return catogeryRepository.findById(cId).get();
    }

    @Override
    public Catogery updateCatogery(Catogery catogery) {
        return catogeryRepository.save(catogery);
    }

    @Override
    public void deleteCatogery(Long cId) {
         catogeryRepository.deleteById(cId);
    }
}
