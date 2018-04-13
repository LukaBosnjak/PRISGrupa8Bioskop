package beans;

import javax.ejb.Remote;

@Remote
public interface BioskopBeanRemote {

	public boolean login(String username, String password);
	public boolean registracija(String username, String password, String rola, byte[] slika);
}
