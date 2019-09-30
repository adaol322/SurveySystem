package surveys.Beans;

import surveys.DTO.AnswersDTO;
import surveys.DTO.SurveysDTO;
import surveys.Entities.*;
import surveys.Utility.DTOMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class SurveysBean {

    @Inject
    DTOMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public void create(SurveysDTO surveysDTO) {
        Surveys surveys = createSurvey(surveysDTO);
        entityManager.persist(surveys);
        surveysDTO.setIdSurveys(surveys.getIdsurveys());
        List<AnswersDTO> answerList = surveysDTO.getAnswersDTOS();
        if (answerList != null) {
            answerList
                    .forEach(answerDTO -> createAnswer(answerDTO, surveysDTO));
        }
    }

    public Surveys createSurvey(SurveysDTO surveysDTO) {
        Surveys surveys = new Surveys();
        //TODO: current date
        surveys.setDate(LocalDate.parse(surveysDTO.getDate()));
        surveys.setLecturers(findLecturerInDBFromSurveyDTO(surveysDTO.getLecturerDTO().getIdLecturers()));
        surveys.setSubjects(findSubjectInDBFromSurveyDTO(surveysDTO.getSubjectDTO().getIdSubjects()));
        return surveys;
    }

    public void createAnswer(AnswersDTO answersDTO, SurveysDTO surveysDTO) {
        Answers answers = new Answers();
        answers.setAnswer(answersDTO.getAnswer());
        answers.setQuestions_fk(findQuestionById(answersDTO.getQuestionDTO().getIdQuestions()));
        answers.setSurveys_fk(findSurveyById(surveysDTO.getIdSurveys()));
        entityManager.persist(answers);
    }

    public Questions findQuestionById(Long idQuestions) {
        return entityManager.createQuery("select x from Questions x where x.idquestions=:idquestion", Questions.class)
                .setParameter("idquestion", idQuestions)
                .getSingleResult();
    }

    public Surveys findSurveyById(Long idSurveys) {
        return entityManager.createQuery("select x from Surveys x where x.idsurveys=:idsurveys", Surveys.class)
                .setParameter("idsurveys", idSurveys)
                .getSingleResult();
    }

    public Lecturers findLecturerInDBFromSurveyDTO(Long idLecturers) {
        return entityManager.createQuery("select x from Lecturers x where x.idLecturers=:idlecturers",
                Lecturers.class)
                .setParameter("idlecturers", idLecturers)
                .getSingleResult();
    }

    public Subjects findSubjectInDBFromSurveyDTO(Long idSubjects) {
        return entityManager.createQuery("select x from Subjects x where x.idsubjects=:idsubject", Subjects.class)
                .setParameter("idsubject", idSubjects)
                .getSingleResult();
    }

    public List<Surveys> lecturerHasSurvey(Long id){
        return entityManager.createQuery("select x from Surveys x where x.lecturers.idLecturers=:idLecturers",  Surveys.class)
                .setParameter("idLecturers", id)
                .getResultList();
    }

    public List<AnswersDTO> getAnswersBySurveyId(Long id) {
        return entityManager.createQuery("select x from Answers x where x.surveys_fk=:idsurveys", Answers.class)
                .setParameter("idsurveys", id)
                .getResultList().stream()
                .map(this::mapToAnswersDTO)
                .collect(Collectors.toList());
    }

    public List<SurveysDTO> readAll() {
        Query query = entityManager.createQuery("select x from Surveys x", Surveys.class);
        List<Surveys> list = query.getResultList();
        return list.stream()
                .map(this::mapToSurveysDTO).collect(Collectors.toList());
    }

    public SurveysDTO find(Long id){
        return mapToSurveysDTO(entityManager.find(Surveys.class, id));
    }

    public SurveysDTO mapToSurveysDTO(Surveys surveys) {
        SurveysDTO surveysDTO = new SurveysDTO();
        surveysDTO.setIdSurveys(surveys.getIdsurveys());
        surveysDTO.setDate(surveys.getDate().toString());
        surveysDTO.setLecturerDTO(mapper.mapToLecturersDTO(surveys.getLecturers()));
        surveysDTO.setSubjectDTO(mapper.mapToSubjectsDTO(surveys.getSubjects()));
        surveysDTO.setAnswersDTOS(surveys.getAnswers().stream()
                .map(this::mapToAnswersDTO)
                .collect(Collectors.toList()));
        return surveysDTO;
    }

    public AnswersDTO mapToAnswersDTO(Answers answers) {
        AnswersDTO answersDTO = new AnswersDTO();
        answersDTO.setIdAnswers(answers.getIdAnswers());
        answersDTO.setAnswer(answers.getAnswer());
        answersDTO.setQuestionDTO(mapper.mapToQuestionsDTO(findQuestionById(answers.getQuestions_fk().getIdquestions())));
        return answersDTO;
    }

}
