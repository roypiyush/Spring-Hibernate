package com.personal.java.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.personal.java.hibernate.model.Company;

public class HibernateMain {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {

		try {
			
			insert(createConfiguration(), "Test");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	private static Configuration createConfiguration() throws IOException,
			FileNotFoundException {
		Configuration configuration = new Configuration();

		configuration
				.addResource("com/personal/java/hibernate-mapping/hibernate-mapping.hbm.xml");

		File file = new File(
				"src/main/resources/com/personal/java/hibernate-mapping/hibernate.properties");
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		configuration.addProperties(properties);

		return configuration;
	}


	public static void insert(Configuration configuration, String value) {

		// SessionFactory is thread-safe
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		// Each thread should gets it own session object
		Session session = sessionFactory.openSession();
		
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			Company company = new Company(value);
			Serializable serializable = (Integer) session.save(company);
			System.out.println(serializable);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction != null)
			transaction.rollback(); // throws hibernateException
		} finally {
			session.close();
		}

		sessionFactory.close();
	}

}
