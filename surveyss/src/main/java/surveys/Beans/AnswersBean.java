package surveys.Beans;

import surveys.DTO.AnswersDTO;
import surveys.DTO.QuestionsDTO;
import surveys.Entities.Answers;
import surveys.Entities.Questions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AnswersBean {
    @PersistenceContext(name = "answers")
    private EntityManager entityManager;

    public void createAnswer(AnswersDTO answersDTO){
        Answers answers = new Answers();
        answers.setAnswer(answersDTO.getAnswer());
        answers.setQuestions_fk(findQuestionById(answersDTO.getQuestionDTO()));

        entityManager.persist(answers);
    }

    public List<Answers> getAnswers(){
        return entityManager.createQuery("select x from Answers x").getResultList();
    }


    public Questions findQuestionById(QuestionsDTO questionDTO){
        return entityManager.createQuery("select x from Questions x where x.question=:question", Questions.class)
                .setParameter("question", questionDTO.getQuestion())
                .getSingleResult();
    }
}
