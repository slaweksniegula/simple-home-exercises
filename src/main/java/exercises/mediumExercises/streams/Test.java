package exercises.mediumExercises.streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

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

    List<String > listOfTitles = movies.stream()
            .map(movie -> movie.getTitle())
            .collect(Collectors.toList());
        System.out.println("Filmy to " + listOfTitles);

        List<String> moviesWithScorupco = movies.stream()
                .filter(movie -> movie.getActors().contains("Izabella Scorupco"))
                .map(movie -> movie.getTitle())
                .collect(Collectors.toList());
        System.out.println("Filmy ze Scorupco to: " + moviesWithScorupco);

        DoubleSummaryStatistics priceStatistics = movies.stream()
                .mapToDouble(movie -> movie.getPrice())
                .summaryStatistics();
        System.out.printf("średnia cena filmu to: %.2f \n", priceStatistics.getAverage());

        List<String> listOfActors = movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Aktorzy to: " + listOfActors);

        Map<String , List<Movie>> moviesByDirectors = movies.stream()
                .collect(Collectors.groupingBy(movie -> movie.getDirector()));
        System.out.println(moviesByDirectors);
    }

}