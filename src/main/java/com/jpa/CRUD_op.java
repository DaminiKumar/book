package com.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CRUD_op {

	private static EntityManager entityManager;
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myapp");
		entityManager = entityManagerFactory.createEntityManager();
		
		insertData();
		//updateData();
		//deleteData();
		//readAllData();
	}

	public static void readAllData() {
		Query query = entityManager.createQuery("SELECT bk from Book bk");//JPQL
		//Query query = entityManager.createNamedQuery("READ_ALL_Data");
		List<Book> bookList = query.getResultList();//Fire JPQL query
		for(Book bk: bookList) {
			System.out.println(bk);
		}
	}
	
	public static void deleteData() {
		entityManager.getTransaction().begin();
		Book bk = entityManager.find(Book.class, 9);
		entityManager.remove(bk);
		entityManager.getTransaction().commit();
		System.out.println("Contact deleted succssfully!!");
	}

	public static void insertData() {

		Book bk=new Book("xyz", 200, "xrrt");
		entityManager.getTransaction().begin();
		entityManager.persist(bk);
		entityManager.getTransaction().commit();
		System.out.println("Contact inserted succssfully!!");
	}

	public static void updateData() {
		entityManager.getTransaction().begin();
		Book bk = entityManager.find(Book.class, 10);
		bk.setPrice(800);
		entityManager.getTransaction().commit();
		System.out.println("Contact updated succssfully!!");
	}

}