package beans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public Film getFilmZaNaziv(String naziv) {
		try {
			Query q = em.createQuery("SELECT f FROM Film f WHERE f.naziv=:n");
			q.setParameter("n", naziv);
			Film f;
    			f = (Film) q.getSingleResult();
    		
    			return f;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Sala getSalaZaBrSale(int brSale) {
		try {
			Query q = em.createQuery("SELECT s FROM Sala s WHERE s.brSale=:br");
			q.setParameter("br", brSale);
			Sala s;
    			s = (Sala) q.getSingleResult();
    		
    			return s;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public double profitUPeriodu(Date fromDate, Date toDate) {
		
		try {
			Query q = em.createQuery("SELECT SUM(k.cena) FROM Karta k WHERE k.datum BETWEEN :from AND :to");
			q.setParameter("from", fromDate);
			q.setParameter("to", toDate);
			double rez = q.getFirstResult();
			return rez;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
