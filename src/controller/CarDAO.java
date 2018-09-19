package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Car;

public class CarDAO {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarsList");
	
	public CarDAO() {}
	
	public void insertItem(Car car) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		em.close();
	}
	
	public Car searchForCarById(int id) {
		EntityManager em = emfactory.createEntityManager();
		Car found = em.find(Car.class,id);
		em.close();
		return found;
	}
	
	public void removeItem(int id) {
		EntityManager em = emfactory.createEntityManager();
		Car toRemove = em.find(Car.class, id);
		em.getTransaction().begin();
		em.remove(toRemove);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeItem(Car car) {
		EntityManager em = emfactory.createEntityManager();
		em.remove(car);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateMake(int id, String make) {
		EntityManager em = emfactory.createEntityManager();
		Car toUpdate = em.find(Car.class, id);
		em.getTransaction().begin();
		toUpdate.setMake(make);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateModel(int id, String model) {
		EntityManager em = emfactory.createEntityManager();
		Car toUpdate = em.find(Car.class, id);
		em.getTransaction().begin();
		toUpdate.setModel(model);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateYear(int id, int year) {
		EntityManager em = emfactory.createEntityManager();
		Car toUpdate = em.find(Car.class, id);
		em.getTransaction().begin();
		toUpdate.setYear(year);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
