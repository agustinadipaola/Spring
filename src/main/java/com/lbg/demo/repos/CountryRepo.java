package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {

}