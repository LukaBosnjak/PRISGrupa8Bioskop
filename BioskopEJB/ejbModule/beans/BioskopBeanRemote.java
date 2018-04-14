package beans;

import javax.ejb.Remote;

import model.Korisnik;

@Remote
public interface BioskopBeanRemote {

	public Korisnik login(String username, String password);
	public boolean registracija(String username, String password, String rola, byte[] slika);
}
