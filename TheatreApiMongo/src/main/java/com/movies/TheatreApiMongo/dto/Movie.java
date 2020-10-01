package com.movies.TheatreApiMongo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

@Document(collection="Theatre")
public class Movie {
    @Id
    private String movieId;
    private String movieName;
    private LocalDate releaseDate;
    private double ticketPrice;
    private Casting movieCast;
}
