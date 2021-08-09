package com.phoenix.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
 * Author kashish.jain@stltech.in
 * Creation date 8-jul-2021
 * Version 1.0
 * Copyright Sterlite Technologies Ltd.
 * Description It is used to perform 
 * 			   database operation using 
 * 			   JPQL.
 */
public class JPQLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		//Hibernate query using JPQL
		//Works on persistent class and it's attributes
		//doesn't understand table and column names
		
		//Query query = ss.createQuery("from Product");
		//Query query = ss.createQuery("from Product p where p.price >= 33000");
		//Query query = ss.createQuery("from Product p where p.brand = 'Samsung'");
		//Query query = ss.createQuery("from Product p where p.productName = 'Phone'");
		//Query query = ss.createQuery("from Product p where p.productName = 'Phone' and p.brand = 'Oneplus'");
		//Query query = ss.createQuery("from Product p where p.price between 25000.00 and 55000.00");
		//Query query = ss.createQuery("from Product p where p.productName like 'L%'");
		//Query query = ss.createQuery("from Product p where p.productName like '%a%'");
		//Query query = ss.createQuery("from Product p where p.productName like '_a%'");
		//Query query = ss.createQuery("from Product p where p.brand is not null");
		//Query query = ss.createQuery("from Product p order by p.price");
		//Query query = ss.createQuery("from Product p order by p.price desc");
		//Query query = ss.createQuery("from Product p order by p.productName,p.price desc");
		//Query query = ss.createQuery("from Product p where p.price <= 50000.00 order by p.price");
		//Query query = ss.createQuery("from Product p where p.price <= 50000.00 and p.brand like '%a%' order by p.price");
		/*
		 * List<Product> products = query.getResultList(); for(Product p:products)
		 * System.out.println(p);
		 */
		//projection selecting particular fields(clmn) in JPQL
		//Query query = ss.createQuery("select p.productName,p.price from Product p");
		//Query query = ss.createQuery("select p.productName,p.brand,p.price from Product p");
		//Query query = ss.createQuery("select p.productName,p.price from Product p where p.price between 5000.00 and 50000.00");
		//Query query = ss.createQuery("select p.productId,p.productName,p.price from Product p where p.price between 5000.00 and 50000.00 order by p.productName");
		/*
		 * List<Object[]> objList = query.getResultList(); for(Object[] obArr : objList)
		 * { //System.out.println("Product Name: "+ obArr[0] + "\tPrice: " + obArr[1]);
		 * for(Object ob: obArr) { System.out.print(ob + "\t"); } System.out.println();
		 * }
		 */
		
		//Group Functions
		//Query query = ss.createQuery("select max(p.price) from Product p");
		/*
		 * float maxPrice = (float)query.getSingleResult();
		 * System.out.println("Max price :"+maxPrice);
		 */
		//Query query = ss.createQuery("select min(p.price) from Product p");
		/*
		 * float minPrice = (float)query.getSingleResult();
		 * System.out.println("Min Price :"+minPrice);
		 */
		//Query query = ss.createQuery("select sum(p.price) from Product p");
		/*
		 * double totalPrice = (double)query.getSingleResult();
		 * System.out.println("Sum is:"+totalPrice);
		 */
		//Query query = ss.createQuery("select avg(p.price) from Product p");
		/*
		 * double avgPrice = (double)query.getSingleResult();
		 * System.out.println("Average Price is: "+ avgPrice);
		 */
		//Query query = ss.createQuery("select count(*),p.brand from Product p group by p.brand");
		//Query query = ss.createQuery("select count(*),p.brand from Product p group by p.brand order by p.brand");
		//Query query = ss.createQuery("select count(*),p.brand from Product p group by p.brand order by count(*)");
		Query query = ss.createQuery("select count(*),p.brand from Product p group by p.brand having p.brand like '%a%' order by count(*)");
		List<Object[]> list = query.getResultList();
		for(Object[] arr:list) {
			for(Object ob:arr) {
				System.out.print(ob + "\t");
			}
			System.out.println();
		}
		tx.commit();
		ss.close();
	}

}
