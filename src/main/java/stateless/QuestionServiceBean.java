package stateless;

import model.Question;
import model.Test;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbreban on 1/3/17.
 */
@Stateless
@Remote(QuestionService.class)
public class QuestionServiceBean implements QuestionService {

  @PersistenceContext(unitName = "UserService")
  private EntityManager em;

  @Override
  public List<Question> getQuestions(int testId) {
    Test test = em.find(Test.class, testId);
    List<Question> questions = new ArrayList<>();
    questions.addAll(test.getQuestions());
    return questions;
  }

  @Override
  public boolean checkAnswer(int questionId, String answer) {
    Question question = em.find(Question.class, questionId);
    return question != null && question.getCorrectAnswer().equals(answer);
  }
}
