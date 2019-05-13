package Entities;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;

@Entity
@Table(name = "Odpowiedzi")
public class Odpowiedzi {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ManyToOne
        @JoinColumn(name = "ID_Pytania")
        private int idPytania;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ManyToOne
        @JoinColumn(name = "ID_Ankiety")
        private int idAnkiety;

        @Column(name = "Odpowiedz")
        private String odpowiedz;

}
