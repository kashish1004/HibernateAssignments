package com.phoenix.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.phoenix.entities.Product;

/*
 * Author kashish.jain@stltech.in
 * Creation date - 7-jul-2021
 * Version 1.0
 * Copyright Sterlite Technologies Ltd.
 * Description It is used to perform 
 * 			   database operation using 
 * 			   hibernate framework
 * */
public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create configuration obj and read hibernate configuration
		Configuration cfg = new Configuration().configure();
		
		//build session factory Singleton class
		SessionFactory factory = cfg.buildSessionFactory();
		
		// establish database connection
		Session ss = factory.openSession();
		
		//obtain hibernate transaction
		Transaction tx = ss.beginTransaction();
		
		//CRUD operations
		Product product = ss.get(Product.class, 104);
		System.out.println(product);
		
		//inserting a row by object
		//Product p = new Product(110,"Mobile","Samsung",50000.00f);
		//ss.save(p);
		
		/*
		 * Product p = ss.load(Product.class,110); System.out.println("Product id: "+
		 * p.getProductId()); System.out.println("Name: "+ p.getProductName());
		 * System.out.println("Brand: "+ p.getBrand()); System.out.println("Price: "+
		 * p.getPrice());
		 */
		//update row price using object
		/*
		 * Product p = ss.get(Product.class,110); if(p!=null) { p.setPrice(53000.00f);
		 * ss.update(p); } else { System.out.println("Sorry!! Product not found"); } p =
		 * ss.get(Product.class,110); if(p!=null) System.out.println(p); else
		 * System.out.println("Sorry!! Product not found");
		 */
		// delete a row using object
		/*
		 * Product p = ss.get(Product.class, 110); if(p!=null) ss.delete(p); else
		 * System.out.println("Sorry!! Product not found");
		 */
		Product pro = new Product(108, null, null, 35000f);
		ss.update(pro);
		//commit transaction
		tx.commit();
		//close session(DB connection)
		ss.close();
	}

}
