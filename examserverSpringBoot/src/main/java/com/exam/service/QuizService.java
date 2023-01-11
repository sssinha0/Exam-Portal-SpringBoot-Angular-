package com.exam.service;

import com.exam.entity.exam.Catogery;
import com.exam.entity.exam.Quiz;
import com.exam.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Set<Quiz> getQuiz();
    public Quiz getQuizById(Long qid);
    public Quiz updateQuiz(Quiz quiz);
    public void deleteQuiz(Long qId);

    public List<Quiz> getAllQuizbyCatogery(Catogery c);
    public List<Quiz> geAllQuizActive();

}
