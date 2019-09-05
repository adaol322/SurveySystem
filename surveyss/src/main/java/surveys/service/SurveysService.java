package surveys.service;

import surveys.DTO.LecturersDTO;
import surveys.DTO.SubjectsDTO;
import surveys.DTO.SurveysDTO;
import surveys.Entities.Lecturers;
import surveys.Entities.Subjects;
import surveys.Entities.Surveys;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@ApplicationScoped
public class SurveysService {

    @PersistenceContext
    EntityManager entityManager;

    public Surveys createSurvey(SurveysDTO surveysDTO) {
        Surveys surveys = new Surveys();
        surveys.setDate(LocalDate.parse(surveysDTO.getDate()));
        surveys.setLecturers(findLecturerInDBFromSurveyDTO(surveysDTO.getLecturerDTO()));
        surveys.setSubjects(findSubjectInDBFromSurveyDTO(surveysDTO.getSubjectDTO()));
        return surveys;
    }

    public Lecturers findLecturerInDBFromSurveyDTO(LecturersDTO lecturersDTO) {
        return entityManager.createQuery("select x from Lecturers x where x.name=:lecturerName and x.surname=:lecturerSurname",
                Lecturers.class)
                .setParameter("lecturerName", lecturersDTO.getName())
                .setParameter("lecturerSurname", lecturersDTO.getSurname())
                .getSingleResult();
    }

    public Subjects findSubjectInDBFromSurveyDTO(SubjectsDTO subjectsDTO) {
        return entityManager.createQuery("select x from Subjects x where x.name=:subjectName", Subjects.class)
                .setParameter("subjectName", subjectsDTO.getName())
                .getSingleResult();
    }

}
