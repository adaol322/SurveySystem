package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pytania")
public class Pytania {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pytania")
    private int idPytania;

    @Column(name = "TrescPytania")
    private String trescPytania;

    @OneToMany(mappedBy = "pytania")
    private List<ZbioryPytan> zbioryPytanList;

    @OneToMany(mappedBy = "idPytania")
    private List<Odpowiedzi> odpowiedziList;

    public int getIdPytania() {
        return idPytania;
    }

    public void setIdPytania(int idPytania) {
        this.idPytania = idPytania;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }

    public List<ZbioryPytan> getZbioryPytanList() {
        return zbioryPytanList;
    }

    public void setZbioryPytanList(List<ZbioryPytan> zbioryPytanList) {
        this.zbioryPytanList = zbioryPytanList;
    }
}
