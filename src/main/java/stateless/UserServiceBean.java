package stateless;

import model.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by sbreban on 1/3/17.
 */
@Stateless
@Remote(UserService.class)
public class UserServiceBean implements UserService {
  @PersistenceContext(unitName="UserService")
  private EntityManager em;

  @Override
  public User getUser(String checkName, String checkPassword) {
    Query query = em.createQuery("select u from User u where u.userName = :name and u.password = :password");
    query.setParameter("name", checkName);
    query.setParameter("password", checkPassword);
    User user = (User)query.getSingleResult();
    return user;
  }
}
