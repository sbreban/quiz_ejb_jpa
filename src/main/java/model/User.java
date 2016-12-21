package model;

/**
 * Created by sbreban on 12/14/16.
 */
public class User {
  private int id;
  private String name;
  private String password;
  private String tests;

  public User(int id, String name, String password, String tests) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.tests = tests;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTests() {
    return tests;
  }

  public void setTests(String tests) {
    this.tests = tests;
  }
}
