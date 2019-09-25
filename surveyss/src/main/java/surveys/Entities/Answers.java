package surveys.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Answers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnswers;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "questions_idquestions", nullable = false)
    private Questions questions_fk;

    @ManyToOne
    @JoinColumn(name = "surveys_idsurveys", nullable = false)
    private Surveys surveys_fk;
}
