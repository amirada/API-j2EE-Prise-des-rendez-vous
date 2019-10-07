package test.test.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.test.persistence.Medecins;
import test.test.persistence.Patients;
import test.test.persistence.Rendezvous;
@Stateless
public class RendezvousService  implements RendezvousServiceLocal, RendezvousServiceRemote {

	@PersistenceContext
	private EntityManager emred;

	public RendezvousService() {
	}

@Override
public void create(Rendezvous rendezvous, int matmed, int matpat) {
	System.out.println(matmed);
	System.out.println(matpat);
	Medecins m = emred.find(Medecins.class, matmed);
	Patients p = emred.find(Patients.class, matpat);
	rendezvous.setPatient(p);
	rendezvous.setMedecins(m);
	List<Rendezvous> medecinsList = m.getRendezvous();
    medecinsList.add(rendezvous);
    m.setRendezvous(medecinsList);
    emred.merge(m);
     List<Rendezvous> patientList = p.getRendezvous();
    patientList.add(rendezvous);
    p.setRendezvous(patientList);
    emred.merge(p);
	emred.persist(rendezvous);
}

@Override
public List<Rendezvous> findAll() {
	// TODO Auto-generated method stub
	return emred.createQuery("from Rendezvous", Rendezvous.class).getResultList();

}
}