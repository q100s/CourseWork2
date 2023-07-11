package pro.sky.java.course2.javaquestionsapp.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.javaquestionsapp.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.WrongQuestionsAmountRequest;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> gottenQuestions = new LinkedHashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new WrongQuestionsAmountRequest("Invalid request");
        }
        while (gottenQuestions.size() < amount) {
            gottenQuestions.add(questionService.getRandomQuestion());
        }
        return gottenQuestions;
    }
}
