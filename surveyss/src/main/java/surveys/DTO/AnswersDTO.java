package surveys.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswersDTO {
    private String answer;
    //TODO enum field for answers: A, B, C, D, E, F
    private Integer idsurveys;
    private Integer idquestions;
}
