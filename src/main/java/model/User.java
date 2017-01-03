package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by sbreban on 12/14/16.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

  @Id
  @GeneratedValue
  private int id;
  private String userName;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="user_test",
      joinColumns=@JoinColumn(name="user_id"),
      inverseJoinColumns=@JoinColumn(name="test_id"))
  private Collection<Test> tests;

  public User() {
  }

  public User(int id, String userName, String password) {
    this.id = id;
    this.userName = userName;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String name) {
    this.userName = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void addTest(Test test) {
    if (!getTests().contains(test)) {
      getTests().add(test);
    }
    if (!test.getUsers().contains(this)) {
      test.getUsers().add(this);
    }
  }

  public Collection<Test> getTests() {
    return tests;
  }
}
