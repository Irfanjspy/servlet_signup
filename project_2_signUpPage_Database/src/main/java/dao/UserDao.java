package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(User user)
	  {
		entityTransaction.begin();
		entityManager.persist(user);
        entityTransaction.commit();
	  }
	
	public User find(String email){
		//  It is used in erlear days (if email is primary key then use this Quary)
		//return entityManager.find(User.class,email);
		
/////////
		//(If id is primary key at that time use this Quary because we dont now about id (it set in servlet or database))
		List<User> user=entityManager.createQuery("select e from User e where email=?1").setParameter(1, email).getResultList();
	    if(user.isEmpty())
	    {
	    	return null;
	    }else
	    	return user.get(0);
	}
	                                                
	public List<User> fetchAll(){
	
		//Query query=entityManager.createQuery("select a from User a",User.class);
		
		//for(User d:)
	 return entityManager.createQuery("select e from User e",User.class).getResultList();
	}
	
	public void delete(User user)
	{
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}
	public void update(User user){
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
}





