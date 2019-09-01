package surveys.Entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString
@EqualsAndHashCode(of = "idLecturers")
public class Lecturers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLecturers;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}
