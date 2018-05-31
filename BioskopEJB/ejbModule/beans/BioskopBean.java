package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Film;
import model.Karta;
import model.Komentar;
import model.Korisnik;
import model.Projekcija;
import model.Rezervacije;


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

	@Override
	public Komentar komentarisi(Date datum, String tekst, Film film, Korisnik korisnik, Komentar kom) {
		try{
			Komentar k = new Komentar();
			k.setDatum(datum);
			k.setTekst(tekst);
			k.setFilm(film);
			k.setKomentar(kom);
			k.setKorisnik(korisnik);
			em.persist(k);
			return k;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/*public boolean rezervisi(Date datum, Projekcija projekcija){
		try{
			Sala s=new Sala();
			int brojMesta=s.getBrMesta();
			if(brojMesta>0){
				Rezervacije rez=new Rezervacije();
				rez.setDatum(datum);
				rez.setProjekcija(projekcija);
				rez.setKorisnik(ulogovan);
				brojMesta--;
				em.persist(rez);
				return true;
			}else{
				System.out.println("Nema mesta");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}*/

	
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
	
	public Karta getKartaZaDatum(Date datum){
		try{
			Query q = em.createQuery("SELECT k FROM Karta k WHERE k.datum=:d");
			q.setParameter("d", datum);
			Karta k=(Karta) q.getSingleResult();
    		return k;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Film> getSviFilmovi() {
		try {
			return em.createQuery("SELECT f from Film f", Film.class).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Komentar> getKomentariZaFilm(Film f) {
		try {
			return em.createQuery("SELECT k FROM Komentar k WHERE k.film=:f", Komentar.class).setParameter("f", f).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean rezervisi(Korisnik k, int idProjekcije) {
		try {
			Projekcija p = em.find(Projekcija.class, idProjekcije);
			Rezervacije r = new Rezervacije();
			r.setKorisnik(k);
			r.setDatum(new Date());
			r.setProjekcija(p);
			r.setIsProdata(false);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Projekcija> getProjekcije() {
		return em.createNamedQuery("Projekcija.findAll", Projekcija.class).getResultList();
	}

}
