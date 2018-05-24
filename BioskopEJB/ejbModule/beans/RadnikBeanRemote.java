package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Rezervacije;

@Remote
public interface RadnikBeanRemote {
	public List<Rezervacije> getRezervacije();
}
