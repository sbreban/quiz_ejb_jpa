package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by sbreban on 12/14/16.
 */
@Entity
@Table(name = "tests")
public class Test implements Serializable {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private int level;
  @ManyToMany
  @JoinTable(name="test_question",
      joinColumns=@JoinColumn(name="test_id"),
      inverseJoinColumns=@JoinColumn(name="question_id"))
  private Collection<Question> questions;

  @ManyToMany(mappedBy="tests")
  private Collection<User> users;

  public Test() {
  }

  public Test(int id, String name, int level) {
    this.id = id;
    this.name = name;
    this.level = level;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void addQuestion(Question question) {
    if (!getQuestions().contains(question)) {
      getQuestions().add(question);
    }
    if (!question.getTests().contains(this)) {
      question.getTests().add(this);
    }
  }

  public Collection<Question> getQuestions() {
    return questions;
  }

  public void addUser(User user) {
    if (!getUsers().contains(user)) {
      getUsers().add(user);
    }
    if (!user.getTests().contains(this)) {
      user.getTests().add(this);
    }
  }

  public Collection<User> getUsers() {
    return users;
  }

  @Override
  public String toString() {
    return "Test{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", level=" + level +
        '}';
  }
}
