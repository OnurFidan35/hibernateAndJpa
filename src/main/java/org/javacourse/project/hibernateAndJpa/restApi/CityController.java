package org.javacourse.project.hibernateAndJpa.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.javacourse.project.hibernateAndJpa.Business.*;
import org.javacourse.project.hibernateAndJpa.Entities.*;

@RestController
@RequestMapping("/api")
public class CityController {

	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/cities")
	public List<City> get() {

		return cityService.getAll();

	}

	@PostMapping("/add")
	public void add(@RequestBody City city) {
	//Parametreyi yapılan isteğin boddysinden alıyoruz
		
		cityService.add(city);

	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {

		cityService.delete(city);

	}

	@PostMapping("/update")
	public void update(@RequestBody City city) {

		cityService.update(city);

	}

	@GetMapping("/cities/{id}")
	//idler aynı isimde olmalı bu şekilde restful api"mizin yolundan değişken olarak aldık
	public City getById(@PathVariable int id) {

	return cityService.getById(id);

	}

}
