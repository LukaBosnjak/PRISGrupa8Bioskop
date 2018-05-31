package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Rezervacije;

@Remote
public interface RadnikBeanRemote {
	public List<Rezervacije> getRezervacijeZaProjekciju(int idProjekcije);
	public boolean prodajKartu(int idProjekcije);
	public boolean prodajRezervisanuKartu(int idProjekcije, int idKorisnika, int idRezervacije);
}
