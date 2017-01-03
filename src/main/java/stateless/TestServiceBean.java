package stateless;

import model.Test;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sbreban on 1/3/17.
 */
@Stateless
@Remote(TestService.class)
public class TestServiceBean implements TestService {

  @PersistenceContext(unitName="UserService")
  private EntityManager em;

  @Override
  public List<Test> getTests(int maxLevel) {
    Query query = em.createQuery("select t from Test t where t.level = :level");
    query.setParameter("level", maxLevel);
    List<Test> tests = query.getResultList();
    return tests;
  }
}
