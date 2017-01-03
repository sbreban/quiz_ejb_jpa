package stateless;

import model.Question;

import java.util.List;

/**
 * Created by sbreban on 1/3/17.
 */
public interface QuestionService {
  List<Question> getQuestions(int testId);
  boolean checkAnswer(int questionId, String answer);
}
