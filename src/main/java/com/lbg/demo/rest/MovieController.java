package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Movie;
import com.lbg.demo.services.MovieService;

// Tells spring this class is a controller
@RestController
public class MovieController {

//	@Autowired
//	private HeroService service;

	private MovieService service;

	public MovieController(MovieService service) {
		super();
		this.service = service;
	}

	// tells spring to listen for a GET request at /hello
	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}

	@GetMapping("/yo")
	public String informal() {
		return "Yo, World!";
	}

	@PostMapping("/create")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) {
		return this.service.createMovie(newMovie);
	}

	@GetMapping("/get")
	public List<Movie> getMovies() {
		return this.service.getMovies();
	}

	// 'id' -> index (for now)
	@GetMapping("/get/{id}")
	public ResponseEntity<Movie> getHero(@PathVariable int id) {
		return this.service.getMovie(id);
	}

	@PutMapping("/update/{id}")
	public Movie updateMovie(@PathVariable int id, @RequestBody Movie newMovie) {
		return this.service.updateMovie(id, newMovie);
	}

	@DeleteMapping("/remove/{id}")
	public Movie remove(@PathVariable int id) {
		return this.service.remove(id);
	}
}