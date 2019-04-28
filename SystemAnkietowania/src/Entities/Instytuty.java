package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instytuty")
public class Instytuty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Instytutu")
    private int idInstytutu;

    @ManyToOne
    @JoinColumn(name = "ID_Wydzialu")
    private Wydzialy wydzialy;

    @Column(name = "NazwaInstytutu")
    private String nazwaInstytutu;

    @Column(name = "NazwaSkrotowaInstytutu")
    private String nazwaSkrotowaInstytutu;

    @OneToMany(mappedBy = "instytut")
    private List<Przedmioty> przedmiotyList;

    public int getIdInstytutu() {
        return idInstytutu;
    }

    public void setIdInstytutu(int idInstytutu) {
        this.idInstytutu = idInstytutu;
    }

    public Wydzialy getWydzialy() {
        return wydzialy;
    }

    public void setWydzialy(Wydzialy wydzialy) {
        this.wydzialy = wydzialy;
    }

    public String getNazwaInstytutu() {
        return nazwaInstytutu;
    }

    public void setNazwaInstytutu(String nazwaInstytutu) {
        this.nazwaInstytutu = nazwaInstytutu;
    }

    public String getNazwaSkrotowaInstytutu() {
        return nazwaSkrotowaInstytutu;
    }

    public void setNazwaSkrotowaInstytutu(String nazwaSkrotowaInstytutu) {
        this.nazwaSkrotowaInstytutu = nazwaSkrotowaInstytutu;
    }

    public List<Przedmioty> getPrzedmiotyList() {
        return przedmiotyList;
    }

    public void setPrzedmiotyList(List<Przedmioty> przedmiotyList) {
        this.przedmiotyList = przedmiotyList;
    }
}
