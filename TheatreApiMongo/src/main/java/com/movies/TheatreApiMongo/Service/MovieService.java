package com.movies.TheatreApiMongo.Service;


import com.movies.TheatreApiMongo.Repository.MovieRepository;
import com.movies.TheatreApiMongo.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Get All Movies
    public List<Movie> getAllMovies(){
        return (List<Movie>) movieRepository.findAll();
    }

    // Get By Movie Name
    public Movie getMovieByName(String movieName) {
        Movie movie = movieRepository.findByMovieName(movieName);
        return movie;
    }

    // Save Movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Update Movie
     public Movie updateMovie(Movie movie,String movieId){
        List<Movie> movieList = (List<Movie>) movieRepository.findAll();
        boolean flag = false;
        for (Movie movie1 : movieList) {
            if(movie1.getMovieId().equals(movieId)) {
                movie1.setMovieId(movie.getMovieId());
                movie1.setMovieName(movie.getMovieName());
                movie1.setReleaseDate(movie.getReleaseDate());
                movie1.setTicketPrice(movie.getTicketPrice());
                movie1.setMovieCast(movie.getMovieCast());

                flag=true;
                return  movie;
            }

        }
        if (flag==false) {
            movieRepository.save(movie);
        }

      return movie;
    }

    // Delete Movie By Name
    public void DeleteMovie(String movieName) {
        movieRepository.deleteByMovieName(movieName);

    }
}
