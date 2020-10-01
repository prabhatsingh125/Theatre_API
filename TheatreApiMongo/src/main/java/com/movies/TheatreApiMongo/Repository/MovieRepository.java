package com.movies.TheatreApiMongo.Repository;

import com.movies.TheatreApiMongo.dto.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie,String> {

    Movie findByMovieName(String movieName);
    void deleteByMovieName(String movieName);

}
