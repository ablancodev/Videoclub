package com.ablancodev.videoclub.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ablancodev.videoclub.model.Movie;

@RestController
@RequestMapping( "/api" )
public class VideoclubAPIController {

	// Vamos a redireccionar / a /movies
	@GetMapping( "" )
	public void redirect(HttpServletResponse response) throws IOException {
	    response.sendRedirect("/api/");
	}

	@GetMapping( "/" )
	public ArrayList<Movie> getMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add( new Movie( "La momia", "Una película de una momia", "/images/momia.jpg" ) );
		movies.add( new Movie( "Misión Imposible", "La primera de la saga de Tom.", "/images/mision.jpg" ) );

		return movies;
	}

}
