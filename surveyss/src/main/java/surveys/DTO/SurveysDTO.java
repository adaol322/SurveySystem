package surveys.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SurveysDTO {
    private Long idSurveys;
    private String date;
    //TODO zmienić wszystko na DTO
    private LecturersDTO LecturerDTO;
    private SubjectsDTO SubjectDTO;
    private List<AnswersDTO> answersDTOS;
}
