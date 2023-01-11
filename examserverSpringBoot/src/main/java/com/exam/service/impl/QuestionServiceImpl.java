package com.exam.service.impl;

import com.exam.dao.DeleteResponse;
import com.exam.dao.ExamResult;
import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.repo.QuestionRepostory;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepostory questionRepostory;
    @Override
    public Question addQuestion(Question question) {
        return questionRepostory.save(question);
    }

    @Override
    public Set<Question> getAllQuestion() {
        return new LinkedHashSet<>(questionRepostory.findAll());
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepostory.save(question);
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepostory.findById(questionId).get();
    }

    @Override
    public ResponseEntity<?> deleteQuestion(Long questionId) {
       questionRepostory.deleteById(questionId);
        DeleteResponse deleteResponse=new DeleteResponse();
        deleteResponse.setCode("200");
        deleteResponse.setMessage("Message Sucessfully deleted");
    return ResponseEntity.accepted().body(deleteResponse);
    }

    @Override
    public List<Question> getAllQuestionOfQuiz(Quiz quiz) {
        return questionRepostory.findByQuiz(quiz);
    }

    @Override
    public ExamResult evaluteExamResult(List<Question> question) {
            int attempt=0;
            int maxMarks=0;
            int correctAnswer=0;
            int size=question.size();
            int marks=(Integer.valueOf(question.get(0).getQuiz().getMaxMarks()))/size;

            for(int i=0;i<size;i++){
                Question question1=questionRepostory.findById(question.get(i).getQuestionId()).get();
                if(question.get(i).getGivenAnswer()!=null)
                    attempt++;
                if(question1.getAnswer().equals(question.get(i).getGivenAnswer())){
                    correctAnswer++;
                }
            }
            maxMarks=marks*correctAnswer;
            ExamResult examResult=new ExamResult();
            examResult.setGotMarks(String.valueOf(maxMarks));
            examResult.setCorrectQuestion(String.valueOf(correctAnswer));
            examResult.setAttemptedQuestion(String.valueOf(attempt));
            return examResult;

    }


}
