package org.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import org.javacourse.project.hibernateAndJpa.Entities.City;


public interface ICityDal {

	
	 List<City> getAll();
	 void add(City city);
	 void update(City city);
	 void delete(City city);
	 City getById(int id);
	 
}
	 
	
