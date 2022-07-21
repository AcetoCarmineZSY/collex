package fr.uvsq.cprog.usestreams;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;


enum sexe{
    male,female;
}

@Data
@AllArgsConstructor
public class Employe {
    private String nom;
    private int age;
    private sexe sex;
    private BigDecimal salaire;
    private LocalDate dateEmbauche;
    private Service serRattachement;
}

