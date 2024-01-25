package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}