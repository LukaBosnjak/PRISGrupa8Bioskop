package beans;

import java.util.Date;

import javax.ejb.Remote;

import model.Film;
import model.Sala;

@Remote
public interface AdministratorBeanRemote {
	
	public boolean unos(Date datum, String tip, Sala sala, Film film);
	
	public Film getFilmZaNaziv(String naziv);
	
	public Sala getSalaZaBrSale(int brSale);
	
	public double profitUPeriodu(Date fromDate, Date toDate);
}
