package surveys.Utility;

import surveys.DTO.LecturersDTO;
import surveys.DTO.QuestionsDTO;
import surveys.DTO.SubjectsDTO;
import surveys.Entities.Lecturers;
import surveys.Entities.Questions;
import surveys.Entities.Subjects;

import javax.ejb.Singleton;

@Singleton
public class DTOMapper {

    public LecturersDTO mapToLecturersDTO(Lecturers lecturers) {
        LecturersDTO lecturersDTO = new LecturersDTO();
        lecturersDTO.setIdLecturers(lecturers.getIdLecturers());
        lecturersDTO.setName(lecturers.getName());
        lecturersDTO.setSurname(lecturers.getSurname());
        return lecturersDTO;
    }

    public QuestionsDTO mapToQuestionsDTO(Questions questions) {
        QuestionsDTO questionsDTO = new QuestionsDTO();
        questionsDTO.setIdQuestions(questions.getIdquestions());
        questionsDTO.setQuestion(questions.getQuestion());
        return questionsDTO;
    }

    public SubjectsDTO mapToSubjectsDTO(Subjects subjects) {
        SubjectsDTO subjectsDTO = new SubjectsDTO();
        subjectsDTO.setIdSubjects(subjects.getIdsubjects());
        subjectsDTO.setName(subjects.getName());
        return subjectsDTO;
    }


}
