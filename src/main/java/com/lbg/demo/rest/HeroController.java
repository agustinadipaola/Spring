package com.lbg.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

	@GetMapping("/agustina")
	public String greeting() {
		return "HELLO HOLA LABAS";
	}

	@GetMapping("/hola")
	public String holaGreeting() {
		return "Aprendiendo con Agus :) ";

	}
}
