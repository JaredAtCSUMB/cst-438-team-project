package cst438.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cst438.domain.*;
import cst438.service.CityService;


@RestController
public class CityRestController {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping("/api/cities")
	public ResponseEntity<?> getCities() {
		List<City> cities = cityService.getCities();

		if (cities.size() == 0) {
			return new ResponseEntity<String>("Unable to fetch cities", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	} 
	
	@PostMapping("/api/cityFromCountry")
	public ResponseEntity<?> getCountry(@RequestParam("countryName") String countryName) {
		List<City> cities = cityRepository.findAllByOrderByNameAsc(countryName);
		
		if(cities == null)
		{
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}
}
