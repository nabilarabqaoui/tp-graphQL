package ma.projet.graph.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;
    private double montant;
    @Temporal(TemporalType.DATE)
    private Date dateTransaction;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type ;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;


    public Transaction(double montant, Date dateTransaction, TypeTransaction type, Compte compte) {
        this.montant = montant;
        this.dateTransaction = dateTransaction;
        this.type = type;
        this.compte = compte;
    }



}