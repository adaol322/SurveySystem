package Entities;

import javax.persistence.*;

@Entity
@Table(name = "Odpowiedzi")
public class Odpowiedzi {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ManyToOne
        @JoinColumn(name = "ID_Pytania")
        private Pytania idPytania;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ManyToOne
        @JoinColumn(name = "ID_Ankiety")
        private WykonaneAnkiety idAnkiety;

        @Column(name = "Odpowiedz")
        private String odpowiedz;
}
