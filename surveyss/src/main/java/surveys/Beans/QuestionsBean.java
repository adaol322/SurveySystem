package surveys.Beans;

import surveys.Entities.Questions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class QuestionsBean {

    @PersistenceContext(name = "questions")
    private EntityManager entityManager;

    public void create(Questions questions) {
        entityManager.persist(questions);
    }


    public List<Questions> readAll() {
        Query query = entityManager.createQuery("select x from Questions x", Questions.class);
        List<Questions> list = query.getResultList();
        return list;
    }
}
