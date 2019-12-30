package com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import model.Hike;
import model.HikeSection;
import model.Person;

public class Main {

	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {

		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();

		Person bob = new Person("Bob", "McRobb");

		List<HikeSection> list1 = new ArrayList<>();
		list1.add(new HikeSection("Penzance", "Mousehole"));
		list1.add(new HikeSection("Mousehole", "St. Levan"));
		list1.add(new HikeSection("St. Levan", "Land's End"));

		Hike cornwall = new Hike("Visiting Land's End", new Date(), new BigDecimal("5.5"), bob, list1);

		List<HikeSection> list2 = new ArrayList<>();
		list2.add(new HikeSection("Freshwater", "Calbourne"));
		list2.add(new HikeSection("Calbourne", "Carisbrooke Castle"));

		Hike isleOfWight = new Hike("Exploring Carisbrooke Castle", new Date(), new BigDecimal("7.5"), bob, list2);
		
		bob.getOrganizedHikes().add(cornwall);
		bob.getOrganizedHikes().add(isleOfWight);
		
		em.persist(bob);
		
		em.getTransaction().commit();
		
		System.out.println("done...");
	}

}
