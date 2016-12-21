package model;

/**
 * Created by sbreban on 12/14/16.
 */
public class Test {
  private int id;
  private String name;
  private int level;

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
}
