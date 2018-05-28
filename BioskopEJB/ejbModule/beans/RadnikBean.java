package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Rezervacije;

/**
 * Session Bean implementation class RadnikBean
 */
@Stateless
@LocalBean
public class RadnikBean implements RadnikBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RadnikBean() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Rezervacije> getRezervacije() {
    		return em.createNamedQuery("Rezervacije.findAll", Rezervacije.class).getResultList();
    }

}
