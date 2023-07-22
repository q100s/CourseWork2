package pro.sky.java.course2.javaquestionsapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.javaquestionsapp.Question;
import pro.sky.java.course2.javaquestionsapp.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question add(Question question) {
        return questionService.add(question);
    }
    @GetMapping("/remove")
    public Question remove(Question question) {
        return questionService.remove(question);
    }
    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
