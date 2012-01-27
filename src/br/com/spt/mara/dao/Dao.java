package br.com.spt.mara.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	private EntityManagerFactory factory = 
		Persistence.createEntityManagerFactory("spt");
	
	public EntityManager getEntityManager(){
		return this.factory.createEntityManager();		
	}
	public void closeFactory(){
		this.factory.close();
	}
}