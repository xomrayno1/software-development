package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Airport;
import com.app.service.AirportService;
import com.app.utils.ResponseUtils;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AirportController extends BaseController{
	
	private AirportService airportService;
	
	private final String root = API + SLASH + V1 + SLASH + AIRPORT;
	
	@GetMapping(value = root )
	public ResponseEntity<Object> airports(){
		List<Airport> airports = airportService.findAll();
		return ResponseUtils.buildResponse(airports);
	}
 
}
