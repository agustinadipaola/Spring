package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Country;
import com.lbg.demo.repos.CountryRepo;

@Service
public class CountryService {

	private CountryRepo repo;

	public CountryService(CountryRepo repo) {
		super();
		this.repo = repo;
	}

	public Country create(Country newCountry) {

		return this.repo.save(newCountry);
	}

	public List<Country> readAll() {
		return this.repo.findAll();
	}

	public ResponseEntity<Country> read(int id) {
		Optional<Country> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(found.get());
	}

	public ResponseEntity<Country> update(int id, Country newCountry) {
		Optional<Country> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Country existing = found.get();

		existing.setName(newCountry.getName());
		existing.setCapital(newCountry.getCapital());

		Country body = this.repo.save(existing);

		return ResponseEntity.ok(body);

	}

	public boolean delete(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}