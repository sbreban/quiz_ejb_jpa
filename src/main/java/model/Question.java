package model;

/**
 * Created by sbreban on 12/14/16.
 */
public class Question {
  private int id;
  private String question;
  private String wrongAnswer;
  private String correctAnswer;

  public Question(int id, String question, String wrongAnswer, String correctAnswer) {
    this.id = id;
    this.question = question;
    this.wrongAnswer = wrongAnswer;
    this.correctAnswer = correctAnswer;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getWrongAnswer() {
    return wrongAnswer;
  }

  public void setWrongAnswer(String wrongAnswer) {
    this.wrongAnswer = wrongAnswer;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }
}
