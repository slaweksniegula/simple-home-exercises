package exercises.mediumExercises.streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("Ogniem i Mieczem", "Jerzy Hoffman", 1999,
                        39.99, Arrays.asList("Akcja", "Historyczny"),
                        Arrays.asList("Izabella Scorupco", "Michał Żebrowski")),
                new Movie("Miasteczko Twin Peaks", "David Lynch", 1990,
                        29.99, Arrays.asList("Dramat", "Kryminał"),
                        Arrays.asList("Kyle MacLachlan", "Michael Ontkean")),
                new Movie("Golden Eye", "Martin Campbell Curtis", 1995,
                        59.99, Arrays.asList("Akcja", "Szpiegowski"),
                        Arrays.asList("Pierce Brosnan", "Izabella Scorupco"))
        );

//Chcemy liste tytulow
        List<String> titles = movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        System.out.println("Tytuły filmów to:" + titles);
//Chcemy liste tytulow filmow z Izabella Scorupco i chcemy je z wielkiej litery
        List<String> moviesWithScorupco = movies.stream()
                .filter(movie -> movie.getActors().contains("Izabella Scorupco"))
                .map(movie -> movie.getTitle())
                .map(title -> title.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Filmy ze Scorupco to: " + moviesWithScorupco);
//Chcemy srednia cene filmu
        DoubleSummaryStatistics priceStatistics = movies.stream()
                .mapToDouble(movie -> movie.getPrice())
                .summaryStatistics();
        System.out.printf("Srednia cena wynosi: %.2f zł. a najwyższa to: %.2f zł. \n", priceStatistics.getAverage(), priceStatistics.getMax());
//Chcemy liste aktorow ze wszystkich filmow
        List<String> actorsList = movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Aktorzy to: " + actorsList);
//Chcemy pogrupowac filmy po rezyserach
        Map<String, List<Movie>> groupByDirector = movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector));
        System.out.println("Grupowanie: " + groupByDirector);

    }
}
