package pro.sky.java.course2.javaquestionsapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.javaquestionsapp.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.WrongQuestionsAmountRequest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    public static final List<Question> QUESTIONS = List.of(
            new Question("1", "1"),
            new Question("2", "2"),
            new Question("3", "3"),
            new Question("4", "4"));
    @Mock
    JavaQuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void init() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
    }
    @Test
    void returnRandomAmountOfQuestions() {
        Random random = new Random();
        when(questionService.getRandomQuestion()).thenReturn(QUESTIONS.get(random.nextInt(0, QUESTIONS.size())));
        int expectedAmount = 1;
        assertEquals(expectedAmount, examinerService.getQuestions(expectedAmount).size());
    }
    @Test
    void throwWrongQuestionsAmountException() {
        int veryBigAmount = 5;
        assertThrows(WrongQuestionsAmountRequest.class, () -> examinerService.getQuestions(veryBigAmount));
    }
}
