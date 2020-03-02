package exercises.mediumExercises.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class Movie {

    private String title;
    private String director;
    private int yearOfProduction;
    private double price;
    private List<String> genre;
    private List<String> actors;



}
