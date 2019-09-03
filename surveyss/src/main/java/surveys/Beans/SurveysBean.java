package surveys.Beans;

import surveys.DTO.SurveysDTO;
import surveys.Entities.Surveys;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SurveysBean {

    @PersistenceContext(name = "surveys")
    private EntityManager entityManager;

    public void create(SurveysDTO surveysDTO) {

        entityManager.persist(surveysDTO);
    }

    public List<Surveys> readAll() {
        Query query = entityManager.createQuery("select x from Surveys x", Surveys.class);
        List<Surveys> list = query.getResultList();
        return list;
    }
}
