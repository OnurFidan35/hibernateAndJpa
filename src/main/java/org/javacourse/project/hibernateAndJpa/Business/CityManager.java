package org.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import org.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import org.javacourse.project.hibernateAndJpa.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Bu classın bir Business katmanı olduğunu belirtiyorum Business yerine Service de kullanılabiliyor eşanlam olarak
public class CityManager implements ICityService{

	private ICityDal cityDal;
	
	@Autowired //Bakacak cityDal parametresine karşılık getirebileceğim bir ICityDal a implement olmuş bir nesne var mı?
			   //sadece HibenateCityDal olduğundan direkt onu karşılık getirecek
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional //Business kodlar için ayrı olarak Transactionlanır.
	public List<City> getAll() {
		
		return cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		//Business:iş kodları
		cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		//Business:iş kodları
		cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		//Business:iş kodları
		cityDal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		//Business:iş kodları
		return cityDal.getById(id);
	}

}
