package com.ablancodev.videoclub.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ablancodev.videoclub.entity.Movie;
import com.ablancodev.videoclub.service.MoviesService;

@RestController
@RequestMapping( "/api" )
public class VideoclubAPIController {

	@Autowired
	@Qualifier( "moviesService" )
	private MoviesService moviesService;

	@GetMapping( "" )
	public void redirect(HttpServletResponse response) throws IOException {
	    response.sendRedirect("/api/");
	}

	@GetMapping( "/" )
	public ArrayList<Movie> getMovies() {
		List<Movie> movies =  moviesService.listAllMovies();

		return (ArrayList<Movie>) movies;
	}

}
