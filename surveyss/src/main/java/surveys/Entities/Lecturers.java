package surveys.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = "idLecturers")
public class Lecturers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLecturers;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @JsonIgnore
    @OneToMany(mappedBy = "lecturers")
    private List<Surveys> surveyss;

}
