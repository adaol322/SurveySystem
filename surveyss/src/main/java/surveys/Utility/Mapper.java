package surveys.Utility;

import surveys.DTO.*;
import surveys.Entities.*;

import javax.ejb.Singleton;
import java.time.LocalDate;

@Singleton
public class Mapper {

    public AnswersDTO mapToAnswersDTO(Answers answers) {
        AnswersDTO answersDTO = new AnswersDTO();
        answers.setAnswer(answers.getAnswer());
        return answersDTO;
    }

    public LecturersDTO mapToLecturersDTO(Lecturers lecturers) {
        LecturersDTO lecturersDTO = new LecturersDTO();
        lecturersDTO.setName(lecturers.getName());
        lecturersDTO.setSurname(lecturers.getSurname());
        return lecturersDTO;
    }

    public QuestionsDTO mapToQuestionsDTO(Questions questions) {
        QuestionsDTO questionsDTO = new QuestionsDTO();
        questionsDTO.setQuestion(questions.getQuestion());
        return questionsDTO;
    }

    public SubjectsDTO mapToSubjectsDTO(Subjects subjects) {
        SubjectsDTO subjectsDTO = new SubjectsDTO();
        subjectsDTO.setName(subjects.getName());
        return subjectsDTO;
    }

    public SurveysDTO mapToSurveysDTO(Surveys surveys) {
        SurveysDTO surveysDTO = new SurveysDTO();
//        surveysDTO.setDate(surveys.getDate());
        return surveysDTO;
    }

    public Answers mapToAnswersEntity(AnswersDTO answersDTO) {
        Answers answers = new Answers();
        answers.setAnswer(answersDTO.getAnswer());
        return answers;
    }

    public Lecturers mapToLecturersEntity(LecturersDTO lecturersDTO) {
        Lecturers lecturers = new Lecturers();
        lecturers.setName(lecturersDTO.getName());
        lecturers.setSurname(lecturersDTO.getSurname());
        return lecturers;
    }

    public Subjects mapToSubjectsEntity(SubjectsDTO subjectsDTO){
        Subjects subjects = new Subjects();
        subjects.setName(subjectsDTO.getName());
        return subjects;
    }

    public Surveys mapToSurvey(SurveysDTO surveysDTO) {
        Surveys surveys = new Surveys();
        surveys.setLecturers(mapToLecturersEntity(surveysDTO.getLecturerDTO()));
        surveys.setSubjects(mapToSubjectsEntity(surveysDTO.getSubjectDTO()));
        surveys.setDate(LocalDate.parse(surveysDTO.getDate()));
        return surveys;
    }
}
