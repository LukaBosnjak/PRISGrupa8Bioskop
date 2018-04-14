package beans;



import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Korisnik;


/**
 * Session Bean implementation class BioskopBean
 */
@Stateful
@LocalBean
public class BioskopBean implements BioskopBeanRemote {
	private Korisnik ulogovan;
	
	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public BioskopBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Korisnik login(String username, String password) {
		try{
    		Query q=em.createQuery("SELECT k FROM Korisnik k WHERE k.username=:username AND k.password=:password");
    		q.setParameter("username", username);
    		q.setParameter("password", password);
    		ulogovan= (Korisnik) q.getSingleResult();
    		
    		return ulogovan;
    	}catch(Exception ee){
    		ee.printStackTrace();
    		return null;
    	}
		
	}

	@Override
	public boolean registracija(String username, String password, String rola, byte[] slika) {
		try{
			Korisnik k=new Korisnik();
			k.setUsername(username);
			k.setPassword(password);
			k.setRola(rola);
			k.setSlika(slika);
			em.persist(k);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		
	}

}
