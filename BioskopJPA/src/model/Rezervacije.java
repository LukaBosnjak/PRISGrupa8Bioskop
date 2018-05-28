package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Rezervacije database table.
 * 
 */
@Entity
@NamedQuery(name="Rezervacije.findAll", query="SELECT r FROM Rezervacije r")
public class Rezervacije implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRezervacije;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Karta
	@ManyToOne
	private Karta karta;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Rezervacije() {
	}

	public int getIdRezervacije() {
		return this.idRezervacije;
	}

	public void setIdRezervacije(int idRezervacije) {
		this.idRezervacije = idRezervacije;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Karta getKarta() {
		return this.karta;
	}

	public void setKarta(Karta karta) {
		this.karta = karta;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}