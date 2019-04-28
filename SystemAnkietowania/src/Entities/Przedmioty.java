package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Przedmioty")
public class Przedmioty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Przedmiotu")
    private int idPrzedmiotu;

    @ManyToOne
    @JoinColumn(name = "ID_Instytutu")
    private Instytuty instytut;

    @Column(name = "Nazwa")
    private String nazwa;

    @Column(name = "NazwaSkrotowa")
    private String nazwaSkrotowa;

    @OneToMany(mappedBy = "przedmioty")
    private List<WykonaneAnkiety> wykonaneAnkietyList;

    public int getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setIdPrzedmiotu(int idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public Instytuty getInstytut() {
        return instytut;
    }

    public void setInstytut(Instytuty instytut) {
        this.instytut = instytut;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwaSkrotowa() {
        return nazwaSkrotowa;
    }

    public void setNazwaSkrotowa(String nazwaSkrotowa) {
        this.nazwaSkrotowa = nazwaSkrotowa;
    }

    public List<WykonaneAnkiety> getWykonaneAnkietyList() {
        return wykonaneAnkietyList;
    }

    public void setWykonaneAnkietyList(List<WykonaneAnkiety> wykonaneAnkietyList) {
        this.wykonaneAnkietyList = wykonaneAnkietyList;
    }
}
