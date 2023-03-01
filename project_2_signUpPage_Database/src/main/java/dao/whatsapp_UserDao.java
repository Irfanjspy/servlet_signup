package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.User;
import dto.whatsapp_User;

public class whatsapp_UserDao {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
      public void save(whatsapp_User user)
      {
    	 transaction.begin();
    	 manager.persist(user);
    	 transaction.commit();
      }
      
      
      public User find(String email){
  		return manager.find(User.class,email);
  	}
}
