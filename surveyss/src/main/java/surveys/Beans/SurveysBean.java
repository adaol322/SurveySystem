package surveys.Beans;

import surveys.DTO.SurveysDTO;
import surveys.Entities.Surveys;
import surveys.service.SurveysService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SurveysBean {

    @PersistenceContext(name = "surveys")
    private EntityManager entityManager;

    @Inject
    SurveysService surveysService;

    public void create(SurveysDTO surveysDTO) {
        Surveys surveys = surveysService.createSurvey(surveysDTO);
        entityManager.persist(surveys);
    }

    public List<Surveys> readAll() {
        Query query = entityManager.createQuery("select x from Surveys x", Surveys.class);
        List<Surveys> list = query.getResultList();
        return list;
    }
}
