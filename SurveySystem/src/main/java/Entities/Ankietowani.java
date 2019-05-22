package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ankietowani")
public class Ankietowani {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Ankietowanego")
    private int idAnkietowanego;

    @Column(name = "ID_Wydzialu")
    private int idWydzialu;

    @Column(name = "Imie")
    private String imie;

    @Column(name = "Nazwisko")
    private String nazwisko;

    @Column(name = "AdresEmail")
    private String adresEmail;

    @Column(name = "RokStudiow")
    private int rokStudiow;

    @Column(name = "Semestr")
    private int semestr;

    @Column(name = "GrupaDziekanska")
    private int grupaDziekanska;

    @Column(name = "Kierunek")
    private String kierunek;

    @OneToMany(mappedBy = "ankietowani")
    private List<WykonaneAnkiety> wykonaneAnkietyList;

    public Ankietowani(int id_wydzialu, String imie, String nazwisko, String adresEmail, int rokStudiow, int semestr, int grupaDziekanska,  String kierunek) {
        this.idWydzialu = id_wydzialu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresEmail = adresEmail;
        this.rokStudiow = rokStudiow;
        this.semestr = semestr;
        this.grupaDziekanska = grupaDziekanska;
        this.kierunek = kierunek;
    }

    public Ankietowani() {
    }

    public int getIdAnkietowanego() {
        return idAnkietowanego;
    }

    public void setIdAnkietowanego(int id_ankietowanego) {
        this.idAnkietowanego = id_ankietowanego;
    }

    public int getIdWydzialu() {
        return idWydzialu;
    }

    public void setIdWydzialu(int id_wydzialu) {
        this.idWydzialu = id_wydzialu;
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

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public int getRokStudiow() {
        return rokStudiow;
    }

    public void setRokStudiow(int rokStudiow) {
        this.rokStudiow = rokStudiow;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public int getGrupaDziekanska() {
        return grupaDziekanska;
    }

    public void setGrupaDziekanska(int grupaDziekanska) {
        this.grupaDziekanska = grupaDziekanska;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public List<WykonaneAnkiety> getWykonaneAnkietyList() {
        return wykonaneAnkietyList;
    }

    public void setWykonaneAnkietyList(List<WykonaneAnkiety> wykonaneAnkietyList) {
        this.wykonaneAnkietyList = wykonaneAnkietyList;
    }
}
