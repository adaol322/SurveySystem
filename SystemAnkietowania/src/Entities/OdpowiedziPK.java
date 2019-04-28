package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OdpowiedziPK implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pytania")
    private int idPytania;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Ankiety")
    private int idAnkiety;
}
