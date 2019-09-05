package surveys.Beans;

import surveys.DTO.AnswersDTO;
import surveys.Entities.Answers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AnswersBean {
    @PersistenceContext(name = "answers")
    private EntityManager entityManager;

    private void createAnswer(AnswersDTO answersDTO){
        Answers answers = new Answers();
        answers.setAnswer(answersDTO.getAnswer());
        entityManager.persist(answers);
    }


}
