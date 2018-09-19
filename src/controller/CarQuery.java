package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;

public class CarQuery {

	public List<Car> searchByMake(String selectedMake) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarsList");
		EntityManager em = emfactory.createEntityManager();
		List<Car> results = null;
		
		try {
			TypedQuery<Car> typedQuery = em.createQuery("select c from Car c"
				+ " where c.make = :make", Car.class);
			typedQuery.setParameter("make",selectedMake);
			results = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emfactory.close();
		}
		return results;
	}
	
	public List<Car> searchByModel(String selectedModel) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarsList");
		EntityManager em = emfactory.createEntityManager();
		List<Car> results = null;
		
		try {
			TypedQuery<Car> typedQuery = em.createQuery("select c from Car c"
				+ " where c.model = :model", Car.class);
			typedQuery.setParameter("model",selectedModel);
			results = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emfactory.close();
		}
		return results;
	}
	
	public List<Car> searchByYear(int selectedYear) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarsList");
		EntityManager em = emfactory.createEntityManager();
		List<Car> results = null;
		
		try {
			TypedQuery<Car> typedQuery = em.createQuery("select c from Car c"
				+ " where c.year = :year", Car.class);
			typedQuery.setParameter("year",selectedYear);
			results = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emfactory.close();
		}
		return results;
	}
	
	public List<Car> searchByMakeModelAndYear(String selectedMake, String selectedModel, int selectedYear) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarsList");
		EntityManager em = emfactory.createEntityManager();
		List<Car> results = null;
		
		try {
			TypedQuery<Car> typedQuery = em.createQuery("select c from Car c"
				+ " where c.make = :make and c.model = :model and c.year = :year", Car.class);
			typedQuery.setParameter("make",selectedMake);
			typedQuery.setParameter("model", selectedModel);
			typedQuery.setParameter("year", selectedYear);
			results = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emfactory.close();
		}
		return results;
	}
	
	public List<Car> retrieveAll() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarsList");
		EntityManager em = emfactory.createEntityManager();
		List<Car> results = null;
		
		try {
			TypedQuery<Car> typedQuery = em.createQuery("select c from Car c", Car.class);
			results = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emfactory.close();
		}
		return results;
	}

}