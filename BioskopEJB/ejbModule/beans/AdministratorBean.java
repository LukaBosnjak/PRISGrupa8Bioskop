package beans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Film;
import model.Projekcija;
import model.Sala;

/**
 * Session Bean implementation class AdministratorBean
 */
@Stateless
@LocalBean
public class AdministratorBean implements AdministratorBeanRemote {
	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AdministratorBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean unos(Date datum, String tip, Sala sala, Film film) {
		try{
			Projekcija p=new Projekcija();
			p.setDatum(datum);
			p.setTip(tip);
			p.setSala(sala);
			p.setFilm(film);
			em.persist(p);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
