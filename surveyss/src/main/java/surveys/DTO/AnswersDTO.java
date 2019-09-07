package surveys.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswersDTO {
    private Long idAnswers;
    private String answer;
    //TODO enum field for answers: A, B, C, D, E, F
    private QuestionsDTO questionDTO;

}
