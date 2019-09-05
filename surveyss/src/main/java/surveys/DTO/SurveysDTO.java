package surveys.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SurveysDTO {
    private String date;
    //TODO zmienić wszystko na DTO
    private LecturersDTO LecturerDTO;
    private SubjectsDTO SubjectDTO;
}
