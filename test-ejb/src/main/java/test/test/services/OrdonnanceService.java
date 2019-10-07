package test.test.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.test.persistence.Medecins;
import test.test.persistence.Ordonnance;
@Stateless
public class OrdonnanceService  implements OrdonnanceServiceLocal, OrdonnanceServiceRemote{
	@PersistenceContext
	private EntityManager emord;
	
	@Override
	public void create(Ordonnance ordonnance) {
		// TODO Auto-generated method stub
		emord.persist(ordonnance);
	}

	@Override
	public List<Ordonnance> findAll() {
		// TODO Auto-generated method stub
		return emord.createQuery("from Ordonnance", Ordonnance.class).getResultList();

	}

	
	

}
