package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Movies;

@RestController
public class MoviesController {

	private List<Movies> movies = new ArrayList<>();
	// tells spring to listen for a GET request at /agustina
//	@GetMapping("/agustina")
//	public String greeting() {
//		return "HELLO HOLA LABAS";
//	}
//
//	@GetMapping("/hola")
//	public String holaGreeting() {
//		return "Aprendiendo con Agus :)";
//	}

//	create
	@PostMapping("/create")
	public Movies createMovies(@RequestBody Movies newMovies) {
		this.movies.add(newMovies);
//		the return below will bring the last entrance from the array  (is -1 since array starts at 0)
//		return the last element in the list
		return this.movies.get(this.movies.size() - 1);
	}

//	view
	@GetMapping("/get")
	public List<Movies> getMovies() {
		return movies;
	}

	// 'id' -> index (for now)
	@GetMapping("/get/{id}")
	public Movies getMovies(@PathVariable int id) {
		return this.movies.get(id);
	}

//	update
	@PatchMapping("/update/{id}")
	public Movies update(@PathVariable int id, @RequestBody Movies moviesDetails) {
		return this.movies.set(id, moviesDetails);
	}

//	delete
	@DeleteMapping("/delete/{id}")
	public Movies deleteMovie(@PathVariable int id) {
		return this.movies.remove(id);
	}
}