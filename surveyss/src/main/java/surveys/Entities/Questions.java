package surveys.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Questions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idquestions;

    @Column(name = "question")
    private String question;

    @JsonIgnore
    @ManyToMany(mappedBy = "questionss")
    private List<Surveys> surveyss;

    @JsonIgnore
    @OneToMany(mappedBy = "questions_fk")
    private List<Answers> answers;

}
