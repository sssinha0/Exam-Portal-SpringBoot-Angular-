package com.exam.entity.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
   private String answer;
   @Column(length = 5000)
   private String content;
   private String image;
   private String op1;
   private String op2;
   private String op3;
   private String op4;

   @Transient
   private String givenAnswer;

   @ManyToOne
    private Quiz quiz;

    public Question() {
    }

    public Question(Long questionId, String answer, String content, String image, String op1, String op2, String op3, String op4, String givenAnswer, Quiz quiz) {
        this.questionId = questionId;
        this.answer = answer;
        this.content = content;
        this.image = image;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.givenAnswer = givenAnswer;
        this.quiz = quiz;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    @JsonIgnore
    public String getAnswer() {
        return answer;
    }
    @JsonProperty
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
