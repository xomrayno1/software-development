package com.app.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.model.Airport;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AirportRepository {
	
	public List<Airport> findAll(){
		log.info(" load from db");
		return Arrays.asList(
				new Airport("Tp. Hồ Chí Minh", "SGN"), new Airport("Hà nội", "HAN"),
				new Airport("Buôn Ma Thuột", "MBV"), new Airport("Cần Thơ", "VCA"),
				new Airport("Chu Lai", "VCL"), new Airport("Đà Lạt", "DLI"),
				new Airport("Đà Nẵng", "DAD"), new Airport("Hải Phòng", "HPH")
				);
	}

}
