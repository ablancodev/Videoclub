package com.ablancodev.videoclub.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ablancodev.videoclub.model.Movie;

@Controller
@RequestMapping( "/api" )
public class VideoclubAPIController {

	// Vamos a redireccionar / a /movies
	@GetMapping( "" )
	public String redirect() {
		return "redirect:/api/";
	}

	@GetMapping( path="/", produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<ArrayList<Movie>> getPersonCustomizedRestrict() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add( new Movie( "La momia", "Una película de una momia", "/images/momia.jpg" ) );
		movies.add( new Movie( "Misión Imposible", "La primera de la saga de Tom.", "/images/mision.jpg" ) );

		return new ResponseEntity<>(movies, HttpStatus.FOUND);  // 302
	}
}
