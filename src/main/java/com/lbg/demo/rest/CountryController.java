package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Country;
import com.lbg.demo.services.CountryService;

@RestController
@RequestMapping("/Country")
public class CountryController {

	private CountryService service;

	public CountryController(CountryService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Country create(@RequestBody Country newCountry) {
		return this.service.create(newCountry);
	}

	@GetMapping("/get")
	public List<Country> readAll() {
		return this.service.readAll();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Country> read(@PathVariable int id) {
		return this.service.read(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Country> update(@PathVariable int id, @RequestBody Country newCountry) {
		return this.service.update(id, newCountry);
	}

	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}
}