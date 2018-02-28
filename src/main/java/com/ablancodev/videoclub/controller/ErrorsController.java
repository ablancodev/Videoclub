package com.ablancodev.videoclub.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

	@ExceptionHandler( Exception.class )
	public String showInternatServerError() {
		return "error/500";
	}
}
