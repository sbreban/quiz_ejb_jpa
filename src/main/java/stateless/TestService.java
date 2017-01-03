package stateless;

import model.Test;

import java.util.List;

/**
 * Created by sbreban on 1/3/17.
 */
public interface TestService {
  List<Test> getTests(int maxLevel);
}
