package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Film;
import model.Komentar;
import model.Korisnik;
import model.Projekcija;

@Remote
public interface BioskopBeanRemote {

	public Korisnik login(String username, String password);
	public boolean registracija(String username, String password, String rola, byte[] slika);
	public Komentar komentarisi(Date datum, String tekst, Film film, Korisnik korisnik, Komentar kom);
	public Film getFilmZaNaziv(String naziv);
	public List<Film> getSviFilmovi();
	public List<Komentar> getKomentariZaFilm(Film f);
	public boolean rezervisi(Korisnik k, int idProjekcije);
	public List<Projekcija> getProjekcije();
}
