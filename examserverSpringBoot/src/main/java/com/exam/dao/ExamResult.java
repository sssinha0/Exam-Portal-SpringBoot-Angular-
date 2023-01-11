package com.exam.dao;

public class ExamResult {
    private String attemptedQuestion;
    private String correctQuestion;
    private String gotMarks;

    public ExamResult(String attemptedQuestion, String correctQuestion, String gotMarks) {
        this.attemptedQuestion = attemptedQuestion;
        this.correctQuestion = correctQuestion;
        this.gotMarks = gotMarks;
    }

    public ExamResult() {
    }

    public String getAttemptedQuestion() {
        return attemptedQuestion;
    }

    public void setAttemptedQuestion(String attemptedQuestion) {
        this.attemptedQuestion = attemptedQuestion;
    }

    public String getCorrectQuestion() {
        return correctQuestion;
    }

    public void setCorrectQuestion(String correctQuestion) {
        this.correctQuestion = correctQuestion;
    }

    public String getGotMarks() {
        return gotMarks;
    }

    public void setGotMarks(String gotMarks) {
        this.gotMarks = gotMarks;
    }
}
