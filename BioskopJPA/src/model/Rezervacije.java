package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the rezervacije database table.
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

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isProdata;

	//bi-directional many-to-one association to Karta
	@OneToMany(mappedBy="rezervacije")
	private List<Karta> kartas;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Projekcija
	@ManyToOne
	private Projekcija projekcija;

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

	public boolean getIsProdata() {
		return this.isProdata;
	}

	public void setIsProdata(boolean isProdata) {
		this.isProdata = isProdata;
	}

	public List<Karta> getKartas() {
		return this.kartas;
	}

	public void setKartas(List<Karta> kartas) {
		this.kartas = kartas;
	}

	public Karta addKarta(Karta karta) {
		getKartas().add(karta);
		karta.setRezervacije(this);

		return karta;
	}

	public Karta removeKarta(Karta karta) {
		getKartas().remove(karta);
		karta.setRezervacije(null);

		return karta;
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

}