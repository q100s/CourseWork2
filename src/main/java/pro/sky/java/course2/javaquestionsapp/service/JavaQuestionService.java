package pro.sky.java.course2.javaquestionsapp.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.javaquestionsapp.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> QUESTIONS = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question questionToAdd = new Question(question, answer);
        QUESTIONS.add(questionToAdd);
        return questionToAdd;
    }

    @Override
    public Question add(Question question) {
        QUESTIONS.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!QUESTIONS.contains(question)) {
            throw new QuestionNotFoundException("There isn't " + question);
        }
        QUESTIONS.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(QUESTIONS));
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = (List<Question>) getAll();
        return questionList.get(random.nextInt(0, questionList.size()));
    }
}
