package com.exam.controller;

import com.exam.entity.exam.Catogery;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @PostMapping("/")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }
    @GetMapping("/{qid}")
    public Quiz getQuizById(@PathVariable("qid")Long qid){
        return quizService.getQuizById(qid);
    }
    @GetMapping("/")
    public Set<Quiz> getAllQuiz(){
        return quizService.getQuiz();
    }
    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return quizService.updateQuiz(quiz);
    }
    @DeleteMapping("/{qid}")
    public void deleteQuizById(@PathVariable("qid")Long qid){
        quizService.deleteQuiz(qid);
    }

    @PostMapping("/getQuizbycat")
    public List<Quiz> getQuizByCatogery(@RequestBody Catogery catogery){

        return this.quizService.getAllQuizbyCatogery(catogery);
    }
    @GetMapping("/allActiveQuiz")
    public List<Quiz> getAllActiveQuiz(){
        return this.quizService.geAllQuizActive();
    }
}
