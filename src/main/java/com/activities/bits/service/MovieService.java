package com.activities.bits.service;

import com.activities.bits.config.MovieConfig;
import com.activities.bits.model.Movie;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MovieConfig movieConfig;

    public List<Movie> getMovies() throws URISyntaxException {
        String getMoviesUrl = movieConfig.getUrl().concat(movieConfig.getMoviesPath());
        URI uri = new URI(getMoviesUrl);
        ResponseEntity<Movie[]> movies = restTemplate.getForEntity(uri, Movie[].class);
        return Arrays.asList(movies.getBody());
    }

    public Movie getMovie(Long id) throws URISyntaxException {
        String getMoviesUrl = movieConfig.getUrl().concat(movieConfig.getMovieByIdPath())
                .concat("/").concat(id.toString());

        URI uri = new URI(getMoviesUrl);
        ResponseEntity<Movie> movie = restTemplate.getForEntity(uri, Movie.class);
        return movie.getBody();
    }
}
