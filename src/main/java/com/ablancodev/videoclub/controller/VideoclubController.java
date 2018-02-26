package com.ablancodev.videoclub.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ablancodev.videoclub.model.Movie;

@Controller
@RequestMapping( "/" )
public class VideoclubController {

	@GetMapping( "/movies" )
	public ModelAndView getMovies() {
		ModelAndView mav = new ModelAndView( "movies" );
		ArrayList<Movie> listado = getRepositoryMovies();
		mav.addObject( "movies", listado);
		return mav;
	}

	private ArrayList<Movie> getRepositoryMovies() {
		ArrayList<Movie> lista = new ArrayList<Movie>();
		lista.add( new Movie( "La momia", "Esto es la momia", "/") );
		lista.add( new Movie( "La momia", "Esto es la momia", "/") );
		return lista;
	}
}
