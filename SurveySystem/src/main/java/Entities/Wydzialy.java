package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Wydzialy")
public class Wydzialy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Wydzialu")
    private int idWydzialu;

    @Column(name = "NazwaWydzialu")
    private String nazwaWydzialu;

    @Column(name = "NazwaSkrotowaWydzialu")
    private String nazwaSkrotowaWydzialu;

    @OneToMany(mappedBy = "wydzialy")
    private List<Instytuty> instytutyList;

    public int getIdWydzialu() {
        return idWydzialu;
    }

    public void setIdWydzialu(int idWydzialu) {
        this.idWydzialu = idWydzialu;
    }

    public String getNazwaWydzialu() {
        return nazwaWydzialu;
    }

    public void setNazwaWydzialu(String nazwaWydzialu) {
        this.nazwaWydzialu = nazwaWydzialu;
    }

    public String getNazwaSkrotowaWydzialu() {
        return nazwaSkrotowaWydzialu;
    }

    public void setNazwaSkrotowaWydzialu(String nazwaSkrotowaWydzialu) {
        this.nazwaSkrotowaWydzialu = nazwaSkrotowaWydzialu;
    }

    public List<Instytuty> getInstytutyList() {
        return instytutyList;
    }

    public void setInstytutyList(List<Instytuty> listOfInstytuty) {
        this.instytutyList = listOfInstytuty;
    }
}
