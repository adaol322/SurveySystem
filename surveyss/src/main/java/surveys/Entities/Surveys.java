package surveys.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@ToString
public class Surveys implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsurveys;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "lecturers_idLecturers", nullable = false)
    private Lecturers lecturers;

    @ManyToOne
    @JoinColumn(name = "subjects_idsubjects", nullable = false)
    private Subjects subjects;

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "surveys_has_questions",
        joinColumns = { @JoinColumn(name = "surveys_idsurveys") },
        inverseJoinColumns = { @JoinColumn(name = "questions_idquestions") }
    )
    List<Questions> questionss;


}
