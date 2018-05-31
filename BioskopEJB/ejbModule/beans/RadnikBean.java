package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Karta;
import model.Korisnik;
import model.Projekcija;
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
    
    public List<Rezervacije> getRezervacijeZaProjekciju(int idProjekcije) {
    		return em.createQuery("SELECT r FROM Rezervacije r WHERE r.projekcija.idProjekcije=:idProjekcije AND r.isProdata=false", Rezervacije.class).setParameter("idProjekcije", idProjekcije).getResultList();
    }
	
    public boolean prodajKartu(int idProjekcije) {
		try {
			Projekcija p = em.find(Projekcija.class, idProjekcije);
			Long brRezevacija = em.createQuery("SELECT COUNT(r) FROM Rezervacije r WHERE r.projekcija.idProjekcije=:idProjekcije AND r.isProdata=false", Long.class).setParameter("idProjekcije", idProjekcije).getSingleResult();
			if(p.getSala().getBrMesta() - brRezevacija.intValue() - p.getKartas().size() > 0) {
				Karta k = new Karta();
				k.setCena(p.getCena());
				k.setDatum(p.getDatum());
				k.setProjekcija(p);
				em.persist(k);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean prodajRezervisanuKartu(int idProjekcije, int idKorisnika, int idRezervacije) {
		try {
			Projekcija p = em.find(Projekcija.class, idProjekcije);
			Rezervacije r = em.find(Rezervacije.class, idRezervacije);
			Korisnik k = em.find(Korisnik.class, idKorisnika);
			if(r == null && k == null) {
				return false;
			}
			if(k.getRezervacijes().contains(r)) {
				Karta karta = new Karta();
				karta.setCena(p.getCena());
				karta.setDatum(p.getDatum());
				karta.setKorisnik(k);
				karta.setRezervacije(r);
				karta.setProjekcija(p);
				em.persist(karta);
				r.setIsProdata(true);
				em.merge(r);
				return true;
			}
 		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
