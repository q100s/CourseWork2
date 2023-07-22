package pro.sky.java.course2.javaquestionsapp.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.javaquestionsapp.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void addPositive() {
        Question expected = new Question("question", "answer");
        assertEquals(javaQuestionService.add("question", "answer"), expected);
        assertTrue(javaQuestionService.getAll().contains(expected));
    }

    @Test
    void removePositive() {
        Question expected = new Question("question", "answer");
        javaQuestionService.add(expected);
        assertTrue(javaQuestionService.getAll().contains(expected));
        javaQuestionService.remove(expected);
        assertFalse(javaQuestionService.getAll().contains(expected));
    }

    @Test
    void removeNonExistentQuestion() {
        Question nonExistentQuestion = new Question("question", "answer");
        assertFalse(javaQuestionService.getAll().contains(nonExistentQuestion));
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(nonExistentQuestion));
    }

    @Test
    void returnAllQuestions() {
        List<Question> expected = new ArrayList<>(List.of(
                new Question("1", "1"),
                new Question("2", "2"),
                new Question("3", "3")
        ));
        javaQuestionService.add("1", "1");
        javaQuestionService.add("2", "2");
        javaQuestionService.add("3", "3");

        assertEquals(javaQuestionService.getAll(), expected);
    }

    @Test
    void getAllRandomQuestion() {
        javaQuestionService.add("1", "1");
        javaQuestionService.add("2", "2");
        javaQuestionService.add("3", "3");

        List<Question> gottenQuestions = (List<Question>) javaQuestionService.getAll();

        Question expected1 = new Question("1", "1");
        Question expected2 = new Question("2", "2");
        Question expected3 = new Question("3", "3");

        assertEquals(gottenQuestions.get(0), expected1);
        assertEquals(gottenQuestions.get(1), expected2);
        assertEquals(gottenQuestions.get(2), expected3);
    }
}
