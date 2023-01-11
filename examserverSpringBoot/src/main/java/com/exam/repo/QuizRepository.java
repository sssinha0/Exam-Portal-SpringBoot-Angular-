package com.exam.repo;

import com.exam.entity.exam.Catogery;
import com.exam.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCatogeryAndActive(Catogery catogery,String active);
    public List<Quiz> findByActive(String active);
}
