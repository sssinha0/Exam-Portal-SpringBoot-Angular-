package com.exam.controller;



import com.exam.dao.ExamResult;
import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

   @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    public Question addAllQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("/")
    public Set<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable("questionId")Long questionId){
        return questionService.getQuestionById(questionId);
    }
    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question){
        return  questionService.updateQuestion(question);
    }
    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable("questionId")Long questionId){
        return questionService.deleteQuestion(questionId);

    }
    @PostMapping("/allQuiz")
    public List<Question> getAllQuestionOfQuiz(@RequestBody Quiz quiz){
        return questionService.getAllQuestionOfQuiz(quiz);
    }
    @PostMapping("/evaluteQuiz")
    public ExamResult evaluteExamResult(@RequestBody List<Question> question){
        return questionService.evaluteExamResult(question);
    }

}
