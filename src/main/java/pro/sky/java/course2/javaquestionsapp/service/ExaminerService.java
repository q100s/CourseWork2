package pro.sky.java.course2.javaquestionsapp.service;

import pro.sky.java.course2.javaquestionsapp.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
