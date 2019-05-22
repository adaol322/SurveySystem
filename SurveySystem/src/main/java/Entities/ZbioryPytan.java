package Entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ZbioryPytan")
public class ZbioryPytan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ZbioruPytan")
    private int idZbioruPytan;

    @Column(name = "ID_Pytania")
    private int idPytania;

    @ManyToOne
    @JoinColumn(name = "ID_Pytania")
    private Pytania pytania;

    @OneToMany(mappedBy = "zbioryPytan")
    private List<WykonaneAnkiety> wykonaneAnkietyList;

    public int getIdZbioruPytan() {
        return idZbioruPytan;
    }

    public void setIdZbioruPytan(int idZbioruPytan) {
        this.idZbioruPytan = idZbioruPytan;
    }

    public int getIdPytania() {
        return idPytania;
    }

    public void setIdPytania(int idPytania) {
        this.idPytania = idPytania;
    }

    public Pytania getPytania() {
        return pytania;
    }

    public void setPytania(Pytania pytania) {
        this.pytania = pytania;
    }

    public List<WykonaneAnkiety> getWykonaneAnkietyList() {
        return wykonaneAnkietyList;
    }

    public void setWykonaneAnkietyList(List<WykonaneAnkiety> wykonaneAnkietyList) {
        this.wykonaneAnkietyList = wykonaneAnkietyList;
    }

}
