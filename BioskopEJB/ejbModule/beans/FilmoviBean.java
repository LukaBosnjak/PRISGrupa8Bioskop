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
    	return em.createQuery("SELECT f FROM Film f where f.zanr=:zanr", Film.class).setParameter("zanr", zanr).getResultList();
    }

}
