package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Film;

/**
 * Session Bean implementation class FilmoviBean
 */
@Stateless
@LocalBean
public class FilmoviBean implements FilmoviBeanRemote {

    @PersistenceContext
    EntityManager em;
	
	/**
     * Default constructor. 
     */
    public FilmoviBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Film nadijFilm(int id) {
    	return em.find(Film.class, id);
    }
    
    public List<Film> izlistajFilmovePoZanru(String zanr) {
    	return em.createQuery("SELECT f FROM Film f WHERE f.zanr=:zanr", Film.class).setParameter("zanr", zanr).getResultList();
    }
    
    public boolean upisiOcenuFilma(int id, double ocena) {
    	try {
	    	Film film = em.find(Film.class, id);
	    	int brPutaOcenjen = film.getBrPutaOcenjen();
	    	film.setBrPutaOcenjen(brPutaOcenjen + 1);
	    	film.setOcena(Math.round(((brPutaOcenjen * film.getOcena() + ocena) / (brPutaOcenjen + 1)) * 10.0) / 10.0);
	    	em.persist(film);
	    	return true;
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    		return false;
    	}
    }

	@Override
	public List<Film> izlistajFilmovePoOceni() {
		return em.createQuery("SELECT f FROM Film f ORDER BY f.ocena DESC", Film.class).getResultList();
	}

}
