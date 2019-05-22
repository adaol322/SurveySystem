package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wykladowcy")
public class Wykladowcy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Wykladowcy")
    private int idWykladowcy;

    @Column(name = "Imie")
    private String imie;

    @Column(name = "Nazwisko")
    private String nazwisko;

    @Column(name = "Tytul")
    private String tytul;

    @Column(name = "AdresEmail")
    private String adresEmail;

    @OneToMany(mappedBy = "wykladowcy")
    private List<WykonaneAnkiety> wykonaneAnkietyList;

    public Wykladowcy(String imie, String nazwisko, String tytul, String adresEmail){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.tytul = tytul;
        this.adresEmail = adresEmail;
    }

    public Wykladowcy() {
    }

    public int getIdWykladowcy() {
        return idWykladowcy;
    }

    public void setIdWykladowcy(int id) {
        this.idWykladowcy = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public List<WykonaneAnkiety> getWykonaneAnkietyList() {
        return wykonaneAnkietyList;
    }

    public void setWykonaneAnkietyList(List<WykonaneAnkiety> wykonaneAnkietyList) {
        this.wykonaneAnkietyList = wykonaneAnkietyList;
    }
}

