package com.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Airport;
import com.app.repository.AirportRepository;
import com.app.service.AirportService;
import com.app.service.cache.LocalCache;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {
	
	private final AirportRepository airportRepository;
	private final LocalCache<Object> localCache;

	@Override
	public List<Airport> findAll() {
		final String airportFindAllKey = "airport#findAll";
		
		Object obj = localCache.get(airportFindAllKey);
		List<Airport> airports = null;
		if(obj == null) {
			airports = airportRepository.findAll();
			//put cache
			localCache.set(airportFindAllKey, airports);
		}else {
			airports = (List<Airport>) obj;
		}
		return airports;
	}

}
