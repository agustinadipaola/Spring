package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Movie;
import com.lbg.demo.repos.MovieRepo;

// Tells spring this class is a controller
@Service
public class MovieService {

	private MovieRepo repo;

	public MovieService(MovieRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Movie> createMovie(Movie newMovie) {
		Movie created = this.repo.save(newMovie);
		return new ResponseEntity<Movie>(created, HttpStatus.CREATED);

	}

	public List<Movie> getMovies() {
		return this.repo.findAll();
	}

	public ResponseEntity<Movie> getMovie(int id) {
		// returns a box that might have a movie in it
		Optional<Movie> found = this.repo.findById(id);
		// checks if its found a movie
		if (found.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
//		attempts to pull the contents out of the box
		Movie body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Movie> updateMovie(int id, Movie newMovie) {
//	returns a box that might have a movie in it
		Optional<Movie> found = this.repo.findById(id);

		if (found.isEmpty()) {
//		checks if its found a movie
			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		}
//	attempts to pull the contents out of the box
		Movie existing = found.get();

		if (newMovie.getTitle() != null) {
			existing.setTitle(newMovie.getTitle());
		}
		if (newMovie.getReleaseYear() != null) {
			existing.setReleaseYear(newMovie.getReleaseYear());
		}
		Movie updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}
