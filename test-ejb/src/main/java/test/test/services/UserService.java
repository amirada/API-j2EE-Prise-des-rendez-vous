package test.test.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.test.persistence.Medecins;
import test.test.persistence.User;
@Stateless
public class UserService  implements UserServiceRemote,UserServiceLocal {
	@PersistenceContext
	private EntityManager emuser;
	
	@Override
	public void create(User user) {
		//System.out.println("here");
		// TODO Auto-generated method stub
		emuser.persist(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return emuser.createQuery("from User", User.class).getResultList();
	}
	
		
	}
