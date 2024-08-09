package org.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.javacourse.project.hibernateAndJpa.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Repository
public class HibernateCityDal implements ICityDal{

	private EntityManager entityManager;
	//Bu class JPA'dan gelir ve sessionımıza karşılık gelir
	
	
	//Autowired Springframeworkte gerekli paketlere bakarak 
	//bu EntityManagerin karşılığı/implementasyonu nedir diyerek gerekli olan injectionu yapacak
	//Hibernate kullanıyoruz bizim için Hibernate enjeksiyonu gerçekleştirecek bizim için.
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	
	
	
	
	//JPA;Java Persistence Api: Hibernate de Spring de JPA'yı implement eder böylelikle:Hızlı bir şekilde hangisini istiyorsak ona
	//geçebiliyoruz Spring istersek Spring'e Hibernate istersek Hibernate'e.
	//SessionFactory ve session JPA kullanılarak otomatik olarak injection'la oluşacak/implement edilecek
	@Override
	//AOP - Aspect Orianted Programming:Transactional işlemi AOP olarak geçer.
	@Transactional //bizim için getAll() methodunun başına ve sonuna bir adet transactionı(Açma-kapama kodları) otomatik kouyuyor
	public List<City> getAll() {
	Session session=	entityManager.unwrap(Session.class);
		//Jpaya bize hibernate session ı ver dedik böylelikle JPA hibernate ile ilgili tüm injectionları gerçekleştirdi
		//bu noktada kafamız rahat
	
	List<City> cities=session.createQuery("from City",City.class).getResultList();
	return cities;
	}
	//JPA kullanarak Hibernate ı çok hızlı ve kısa bir şekilde kodlamış olduk
	

	@Override
	public void add(City city) {
	Session session=entityManager.unwrap(Session.class);	
	//If() koyulabilir çünkü var olan şehir gönderilirse yanlışlıkla update edilebilir bu riski if ile çözebiliriz
	session.persist(city);
		
	}

	@Override
	public void update(City city) {
	Session session=entityManager.unwrap(Session.class);	
	session.merge(city);	
		
		
	}

	@Override
	public void delete(City city) {
		Session session=entityManager.unwrap(Session.class);
		City cityToDelete=session.get(City.class,city.getId());
		session.remove(cityToDelete);
		
	}







	@Override
	public City getById(int id) {
		Session session=entityManager.unwrap(Session.class);	
		City city = session.get(City.class,id);
		return city;
	}

	
	
	
	
	
}
