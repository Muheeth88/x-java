// package com.xapp.xjava.services;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.xapp.xjava.entities.MovieEntity;
// import com.xapp.xjava.repositories.MoviesRepository;

// @Service
// public class MoviesService {

// @Autowired
// private MoviesRepository moviesRepository;

// public MovieEntity addMovie(MovieEntity req) {

// MovieEntity newMovie = new MovieEntity();
// newMovie.setTitle(req.getTitle());
// newMovie.setTagline(req.getTagline());
// newMovie.setPlotSummary(req.getPlotSummary());
// newMovie.setOriginalLanguage(req.getOriginalLanguage());
// newMovie.setCountryOfOrigin(req.getCountryOfOrigin());
// newMovie.setGenres(req.getGenres());
// newMovie.setType(req.getType());
// newMovie.setReleaseDate(req.getReleaseDate());

// return moviesRepository.save(newMovie);
// }

// public List<MovieEntity> getAllMovies() {
// List<MovieEntity> allMovies = moviesRepository.findAll();
// return allMovies;
// }

// public Optional<MovieEntity> getUser(Long userId) {
// Optional<MovieEntity> movie = moviesRepository.findById(userId);
// return movie;
// }

// }
