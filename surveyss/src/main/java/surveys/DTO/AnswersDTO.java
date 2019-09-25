package surveys.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswersDTO {
    private Long idAnswers;
    private String answer;
    private QuestionsDTO questionDTO;

}
