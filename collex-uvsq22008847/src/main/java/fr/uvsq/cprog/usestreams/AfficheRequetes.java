package fr.uvsq.cprog.usestreams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AfficheRequetes {
    public static void main(String[] args) {
        //Créez un jeu de données de test
        List<Employe> testlist = Arrays.asList(
            new Employe("Alice", 20, sexe.female, BigDecimal.valueOf(9000), LocalDate.of(2020, 6, 1), Service.SERVICE_ONE),
            new Employe("Bob", 26, sexe.male, BigDecimal.valueOf(11000),LocalDate.of(2019, 10, 1), Service.SERVICE_TWO),
            new Employe("Charlie", 36, sexe.male, BigDecimal.valueOf(21000),LocalDate.of(2010, 3, 1), Service.SERVICE_TWO),
            new Employe("David", 31, sexe.male, BigDecimal.valueOf(30000),LocalDate.of(2009, 4, 1), Service.SERVICE_ONE),
            new Employe("Eva", 28, sexe.female, BigDecimal.valueOf(20000),LocalDate.of(2014, 12, 1), Service.SERVICE_TWO)
        );

        //Implémentez les requêtes suivantes (faites afficher le résultat)
        //Les employés (avec toutes leurs caractéristiques)
        System.out.println("Les employés (avec toutes leurs caractéristiques):");

        //another way with lamda: testlist.stream().forEach(str -> System.out.println(str));
        testlist.stream().forEach(System.out::println);


        //Les employés de moins de 30 ans
        System.out.println("\nLes employés de moins de 30 ans:");
        Predicate<Employe> predicate2 = e -> e.getAge()<30;
        List<Employe> collect2= testlist.stream()
                                        .filter(predicate2)              //trouver les employés de moins de 30 ans
                                        .collect(Collectors.toList());   //create le nouvel liste
        System.out.println(collect2);


        //Le nom des hommes
        System.out.println("\nLe nom des hommes:");
        Predicate<Employe> predicate3 = e -> e.getSex()==sexe.male;
        testlist.stream().filter(predicate3).forEach(e -> System.out.println(e.getNom()));

 
        //le nom et le salaire trié par salaire décroissant
        System.out.println("\nLe nom et le salaire trié par salaire décroissant:");
        testlist.stream().sorted(Comparator.comparing(Employe::getSalaire).reversed())  //trié par salaire décroissant
                         .forEach(e -> System.out.println(e.getNom()+", "+e.getSalaire()));  //affiche le nom et le salaire


        //la moyenne des salaires
        System.out.println("\nLa moyenne des salaires:");
        System.out.println(testlist.stream().mapToDouble(e -> e.getSalaire().doubleValue()).average().getAsDouble());


        //les employés regroupés selon leur sexe
        System.out.println("\nLes employés regroupés selon leur sexe:");

        Map<sexe, List<Employe>> collect6 = testlist.stream().collect(Collectors.groupingBy(Employe::getSex));
        System.out.println(collect6);


        //la moyenne des salaires par sexe
        System.out.println("\nLa moyenne des salaires par sexe:");
        Map<sexe, Double> collect7 = testlist.stream()
                                            .collect(Collectors.groupingBy(Employe::getSex, Collectors.averagingDouble(e -> e.getSalaire().doubleValue())));
        System.out.println(collect7);

        //le nom et la date d'embauche par services
        System.out.println("\nLe nom et la date d'embauche par services:");
        //Groupe par service
        Map<Service, List<Employe>> collect8 = testlist.stream().collect(Collectors.groupingBy(Employe::getSerRattachement));
        //Affiche le nom et le date
        for (Service s: collect8.keySet()){
            System.out.println("\n"+ s +":");
            collect8.get(s).stream().forEach(e -> System.out.println(e.getNom()+ ", "+ e.getDateEmbauche()));
        }
    }
}
