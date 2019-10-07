package test.test.services;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.rowset.serial.SerialBlob;
import javax.ws.rs.core.Response;
import test.test.persistence.Medecins;
import test.test.persistence.MyEntity;
import test.test.persistence.Patients;

@Stateless
public class MedecinsService  implements MedecinsServiceRemote,MedecinsServiceLocal{
	private static final Response Response = null;
	@PersistenceContext
	private EntityManager emmd;
	
	public MedecinsService() {
	}

	@Override
	public void create(Medecins medecins) {
		// TODO Auto-generated method stub
		emmd.persist(medecins);
	}
	@Override
	public void uploadBinary( MyEntity myEntity,Integer matmed) {
		
		
		
		System.out.println(myEntity.getData());
		
		//Medecins p = emmd.find(Medecins.class, matmed);
		//System.out.println(myEntity.getData());
		
		//p.setData(myEntity.getData());
		
		//emmd.merge(p);
			 
	}

	@Override
	public void getimage(Integer matmed) {
		System.out.println("iciiiii");
		Medecins p = emmd.find(Medecins.class, matmed);
		System.out.println(p.getData());
			
		try {
            //Blob blob = staticOffer.getImage(); //blob of image from db
            StringBuffer strOut = new StringBuffer();
            String aux;
            BufferedReader br;
           
            Blob blob=new SerialBlob(p.getData());
            br = new BufferedReader(new InputStreamReader(blob.getBinaryStream()));
            while ((aux=br.readLine())!=null) {
                strOut.append(aux);
            }
            String offerPicStr = strOut.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		emmd.merge(p);
			 
	}
	
	@Override
	public void Edit(Integer matmed, Medecins medecins ) {
		
		Medecins pat=emmd.find(Medecins.class, matmed);
		
		System.out.println(matmed);
		System.out.println(medecins.getNom());
		
		
	
		medecins.setMatmed(pat.getMatmed());
		emmd.merge(medecins);
	}


	@Override
	public Medecins login(Medecins medecins) {

		List<Medecins> medecinsList = emmd.createQuery("from Medecins", Medecins.class).getResultList();
		for (int i = 0; i < medecinsList.size(); i++) {
			if (medecins.getPassword().equals(medecinsList.get(i).getPassword())
					&& medecins.getNom().equals(medecinsList.get(i).getNom())) {
				return medecinsList.get(i);
			}

		}
		return null;
	}
	
	@Override
	public List<Medecins> findAll() {
		// TODO Auto-generated method stub
		return emmd.createQuery("from Medecins", Medecins.class).getResultList();
	}

	@Override
	public void delete(Integer matmed) {
		System.out.println("delete here");
		// TODO Auto-generated method stub
		Object message = "succee";
		Object message1 = "non";
		Medecins u = emmd.find(Medecins.class, matmed);

		if (u != null) {
			emmd.remove(u);
		
			
		} 
	}
	
	@Override
	public Medecins ajout(Medecins medecin) {
		emmd.persist(medecin);
		return medecin;
	}
	
	
	

}
