package com.movies.TheatreApiMongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.movies.TheatreApiMongo.Service.MovieService;
import com.movies.TheatreApiMongo.dto.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class TheatreApiMongoApplicationTests {

	@Autowired
	private MovieService movieService;

	@Test
	void BodyGuardMoviePriceTest() {

		Movie movie = movieService.getMovieByName("BodyGuard");
		assertEquals(movie.getTicketPrice(),150);
	}

	@Test
	void SimranChawlaReleaseDateTest() {
		Movie movie = movieService.getMovieByName("Simran Chawla");
		assertEquals(movie.getReleaseDate(), LocalDate.parse("2020-08-10"));
	}

}
