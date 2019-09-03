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
@ToString
public class Subjects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsubjects;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subjects")
    private List<Surveys> surveyss;

}
