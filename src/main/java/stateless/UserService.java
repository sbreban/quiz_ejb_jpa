package stateless;

import model.User;

/**
 * Created by sbreban on 1/3/17.
 */
public interface UserService {
  User getUser(String checkName, String checkPassword);
}
