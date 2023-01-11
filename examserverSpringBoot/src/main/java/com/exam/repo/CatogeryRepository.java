package com.exam.repo;

import com.exam.entity.exam.Catogery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatogeryRepository extends JpaRepository<Catogery,Long> {
}
