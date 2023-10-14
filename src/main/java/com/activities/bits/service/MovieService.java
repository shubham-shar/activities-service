package com.activities.bits.service;

import com.activities.bits.model.Movie;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> getMovies() {

        Movie movie1 = Movie.builder()
                .id(1234L)
                .title("Movie1")
                .build();
        Movie movie2 = Movie.builder()
                .id(2567L)
                .title("movie2")
                .build();
        return Arrays.asList(movie1, movie2);
    }

    public Movie getMovie(Long id) {
        return Movie.builder()
                .id(id)
                .title("Movie1")
                .description("Demon slayer animation")
                .releaseDate("2023-10-13")
                .build();
    }
}
