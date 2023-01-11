package com.exam.service.impl;

import com.exam.entity.exam.Catogery;
import com.exam.entity.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuiz() {
        return new LinkedHashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuizById(Long qid) {
        return quizRepository.findById(qid).get();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(Long qId) {
       quizRepository.deleteById(qId);
    }

    @Override
    public List<Quiz> getAllQuizbyCatogery(Catogery c) {
        return quizRepository.findByCatogeryAndActive(c,"true");
    }

    @Override
    public List<Quiz> geAllQuizActive() {
        return quizRepository.findByActive("true");
    }
}
