package com.exam.repo;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepostory extends JpaRepository<Question,Long> {
    public List<Question> findByQuiz(Quiz quiz);
}
