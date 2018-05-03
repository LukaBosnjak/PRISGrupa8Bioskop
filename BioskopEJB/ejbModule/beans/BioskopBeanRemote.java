package beans;

import java.util.Date;

import javax.ejb.Remote;

import model.Film;
import model.Komentar;
import model.Korisnik;

@Remote
public interface BioskopBeanRemote {

	public Korisnik login(String username, String password);
	public boolean registracija(String username, String password, String rola, byte[] slika);
	public Komentar komentarisi(Date datum, String tekst, Film film, Korisnik korisnik, Komentar kom);
}
