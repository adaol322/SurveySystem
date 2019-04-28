package Entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WykonaneAnkiety")
public class WykonaneAnkiety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Ankiety")
    private int idAnkiety;

    @ManyToOne
    @JoinColumn(name = "ID_Ankietowanego")
    private Ankietowani ankietowani;

    @ManyToOne
    @JoinColumn(name = "ID_ZbioruPytan")
    private ZbioryPytan zbioryPytan;

    @ManyToOne
    @JoinColumn(name = "ID_Wykladowcy")
    private Wykladowcy wykladowcy;

    @ManyToOne
    @JoinColumn(name = "ID_Przedmiotu")
    private Przedmioty przedmioty;

    @Column(name = "Data_Wykonania")
    private Date dataWykonania;

    public int getIdAnkiety() {
        return idAnkiety;
    }

    public void setIdAnkiety(int idAnkiety) {
        this.idAnkiety = idAnkiety;
    }

    public Ankietowani getAnkietowani() {
        return ankietowani;
    }

    public void setAnkietowani(Ankietowani ankietowani) {
        this.ankietowani = ankietowani;
    }

    public ZbioryPytan getZbioryPytan() {
        return zbioryPytan;
    }

    public void setZbioryPytan(ZbioryPytan zbioryPytan) {
        this.zbioryPytan = zbioryPytan;
    }

    public Wykladowcy getWykladowcy() {
        return wykladowcy;
    }

    public void setWykladowcy(Wykladowcy wykladowcy) {
        this.wykladowcy = wykladowcy;
    }

    public Przedmioty getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(Przedmioty przedmioty) {
        this.przedmioty = przedmioty;
    }

    public Date getDataWykonania() {
        return dataWykonania;
    }

    public void setDataWykonania(Date dataWykonania) {
        this.dataWykonania = dataWykonania;
    }
}
