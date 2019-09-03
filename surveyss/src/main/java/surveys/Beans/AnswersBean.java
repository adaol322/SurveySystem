package surveys.Beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AnswersBean {
    @PersistenceContext(name = "answers")
    private EntityManager entityManager;


}
