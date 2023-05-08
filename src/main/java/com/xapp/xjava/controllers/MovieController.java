package com.xapp.xjava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xapp.xjava.entities.MovieEntity;
import com.xapp.xjava.services.MoviesService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("")
    ResponseEntity<List<MovieEntity>> getAllMovies() {
        List<MovieEntity> allMovies = moviesService.getAllMovies();
        return ResponseEntity.ok(allMovies);

    }

    @GetMapping("/{movieId}")
    ResponseEntity<Optional<MovieEntity>> getUser(@PathVariable("movieId") Long movieId) {
        Optional<MovieEntity> movie = moviesService.getUser(movieId);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("")
    ResponseEntity<MovieEntity> addMovie(@RequestBody MovieEntity req) {
        MovieEntity newMovie = moviesService.addMovie(req);
        return ResponseEntity.ok(newMovie);
    }
}
