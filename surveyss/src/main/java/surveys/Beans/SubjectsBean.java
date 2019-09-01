package surveys.Beans;

import surveys.Entities.Subjects;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SubjectsBean {

    @PersistenceContext(name = "subjects")
    private EntityManager entityManager;

    public void create(Subjects subjects) {
        entityManager.persist(subjects);
    }


    public List<Subjects> readAll() {
        Query query = entityManager.createQuery("select x from Subjects x", Subjects.class);
        List<Subjects> list = query.getResultList();
        return list;
    }
}
