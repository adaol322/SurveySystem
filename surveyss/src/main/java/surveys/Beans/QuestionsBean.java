package surveys.Beans;

import surveys.DTO.QuestionsDTO;
import surveys.Entities.Lecturers;
import surveys.Entities.Questions;
import surveys.Utility.DTOMapper;
import surveys.Utility.Result;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class QuestionsBean {

    @PersistenceContext(name = "questions")
    private EntityManager entityManager;

    @Inject
    DTOMapper dtoMapper;

    public void create(QuestionsDTO questionsDTO) {
        Questions questions = new Questions();
        questions.setQuestion(questionsDTO.getQuestion());
        entityManager.persist(questions);
    }

    public Questions findById(Long id){
        return entityManager.find(Questions.class, id);
    }

    public List<QuestionsDTO> readAll() {
        Query query = entityManager.createQuery("select x from Questions x", Questions.class);
        List<Questions> list = query.getResultList();
        return list.stream()
                .map(dtoMapper::mapToQuestionsDTO).collect(Collectors.toList());
    }

    public Result delete(Long id){
        Questions questions;
        try{
            questions = findById(id);
            entityManager.remove(questions);
            return Result.SUCCESS;
        } catch(Exception ex){
            return Result.FAILURE;
        }
    }
}
