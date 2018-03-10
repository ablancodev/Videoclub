package com.ablancodev.videoclub.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ablancodev.videoclub.entity.Movie;
import com.ablancodev.videoclub.repository.MovieJpaRepository;
import com.ablancodev.videoclub.service.MoviesService;

@Controller
@RequestMapping( "/" )
public class VideoclubController {

	@Autowired
	@Qualifier( "moviesService" )
	private MoviesService moviesService;

	/*
	@Autowired
	@Qualifier( "movieJpaRepository" )
	private MovieJpaRepository movieJpaRepository;
	*/

	// Vamos a redireccionar / a /movies
	@GetMapping( "/" )
	public String redirect() {
		return "redirect:/movies";
	}

	@GetMapping( "/movies" )
	public ModelAndView getMovies() {
		ModelAndView mav = new ModelAndView( "movies" );
		List<Movie> listado =  moviesService.listAllMovies();
		mav.addObject( "movies", listado);
		return mav;
	}

	/*
	// .../movie?id=xx
	@GetMapping( "/movie" )
	public ModelAndView getMovie( @RequestParam( name="id", required=false, defaultValue="NULL" ) String id ) {
		ModelAndView mav = new ModelAndView( "movie" );
		mav.addObject( "idMovie", id );
		return mav;
	}
	*/

	// .../movie/xx
	@GetMapping( "/movie/{id}" )
	public ModelAndView getMovie( @PathVariable( "id" ) String id ) {
		ModelAndView mav = new ModelAndView( "movie" );
		mav.addObject( "idMovie", id );
		return mav;
	}

	@GetMapping( "/addMovie" )
	public String addMovie( Model model ) {
		model.addAttribute( "movie", new Movie() );
		return "addMovie";
	}

	@PostMapping( "/actionAddMovie")
	public ModelAndView actionAddMovie( @Valid @ModelAttribute( "movie" ) Movie movie, BindingResult bindingResult ) {
		ModelAndView mav = null;
		if ( bindingResult.hasErrors() ) {
			mav = new ModelAndView( "addMovie" );
		} else {
			moviesService.addMovie( movie );
			mav = new ModelAndView( "result" );
			mav.addObject( "movie", movie );
		}
		return mav;
	}

}
