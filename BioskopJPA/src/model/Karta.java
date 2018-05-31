package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the karta database table.
 * 
 */
@Entity
@NamedQuery(name="Karta.findAll", query="SELECT k FROM Karta k")
public class Karta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKarte;

	private double cena;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnik_idKorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Projekcija
	@ManyToOne
	private Projekcija projekcija;

	//bi-directional many-to-one association to Rezervacije
	@ManyToOne
	private Rezervacije rezervacije;

	public Karta() {
	}

	public int getIdKarte() {
		return this.idKarte;
	}

	public void setIdKarte(int idKarte) {
		this.idKarte = idKarte;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Projekcija getProjekcija() {
		return this.projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public Rezervacije getRezervacije() {
		return this.rezervacije;
	}

	public void setRezervacije(Rezervacije rezervacije) {
		this.rezervacije = rezervacije;
	}

}