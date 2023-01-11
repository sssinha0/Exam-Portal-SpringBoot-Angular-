package com.exam.service;

import com.exam.dao.ExamResult;
import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);
    public Set<Question> getAllQuestion();
    public Question updateQuestion(Question question);
    public Question getQuestionById(Long questionId);
    public ResponseEntity<?> deleteQuestion(Long questionId);

    public List<Question> getAllQuestionOfQuiz(Quiz quiz);

    public ExamResult evaluteExamResult(List<Question> question);
}
