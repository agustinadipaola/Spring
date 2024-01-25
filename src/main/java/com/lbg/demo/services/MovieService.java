package com.lbg.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Movie;

// Tells spring this class is a controller
@Service
public class MovieService {

	private List<Movie> movies = new ArrayList<>();

	public ResponseEntity<Movie> createMovie(Movie newMovie) {
		this.movies.add(newMovie);
		// returns the last element in the list
		Movie body = this.movies.get(this.movies.size() - 1);

		return new ResponseEntity<Movie>(body, HttpStatus.CREATED);
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public ResponseEntity<Movie> getMovie(int id) {
		if (id < 0 || id >= this.movies.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Movie found = this.movies.get(id);

		return ResponseEntity.ok(found);
	}

	public Movie updateMovie(int id, Movie newMovie) {
		return this.movies.set(id, newMovie);
	}

	public Movie remove(int id) {
		return this.movies.remove(id);
	}
}