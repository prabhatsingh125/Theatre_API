package com.movies.TheatreApiMongo.Controller;

import com.movies.TheatreApiMongo.Service.MovieService;
import com.movies.TheatreApiMongo.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

   @Autowired
    private MovieService movieService;

    @GetMapping("/AllMovies")
    ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movieList = movieService.getAllMovies();
        System.out.println("List Of All Movies are ");
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/Movie/{movieName}")
    ResponseEntity<Movie> getMovieByName(@PathVariable String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        System.out.println("The Movies are ");
        return ResponseEntity.ok(movie);

    }

    @PostMapping("/Movie")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        Movie movie1 = movieService.saveMovie(movie);
        System.out.println("The Movie Saving is "+ movie1);
        return ResponseEntity.ok(movie1);


    }

    @PutMapping("/Movie/{movieId}")
    ResponseEntity<Movie> updateMovie(@RequestBody Movie movie,@PathVariable String movieId) {
        Movie movie1 = movieService.updateMovie(movie,movieId);
        System.out.println("The Updated Movie is "+ movie1);
        System.out.println("The Updated Movie Id is "+ movieId);
        return ResponseEntity.ok(movie1);

    }

    @DeleteMapping("/Movie/{movieName}")
    ResponseEntity<String> deleteMovie(@PathVariable String movieName) {
        movieService.DeleteMovie(movieName);
        System.out.println("The Deleted Movie Name is "+ movieName);
        return ResponseEntity.ok("Deleted");
    }
}
