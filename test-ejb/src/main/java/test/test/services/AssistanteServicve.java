package test.test.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.test.persistence.Assistante;
import test.test.persistence.Medecins;
@Stateless
public class AssistanteServicve implements AssistanteServiceRemote,AssistanteServiveLocal
{
	@PersistenceContext
	private EntityManager emass;
	
	public AssistanteServicve() {
	}
	@Override
	public void create(Assistante assistante) {
		// TODO Auto-generated method stub
		emass.persist(assistante);
	}

	@Override
	public Assistante login(Assistante assistante) {

		List<Assistante> assistanteList = emass.createQuery("from Assistante", Assistante.class).getResultList();
		for (int i = 0; i < assistanteList.size(); i++) {
			if (assistante.getPassword().equals(assistanteList.get(i).getPassword())
					&& assistante.getNom().equals(assistanteList.get(i).getNom())) {
				return assistanteList.get(i);
			}

		}
		return null ;
	}
	
	@Override
	public List<Assistante> findAll() {
		// TODO Auto-generated method stub
		return emass.createQuery("from Assistante", Assistante.class).getResultList();
	}
	
	
	
	
	
	

	
	
	

}
