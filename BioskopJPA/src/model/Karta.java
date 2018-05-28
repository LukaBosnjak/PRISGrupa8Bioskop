package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Karta database table.
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

	//bi-directional many-to-one association to Projekcija
	@ManyToOne
	private Projekcija projekcija;

	//bi-directional many-to-one association to Rezervacije
	@OneToMany(mappedBy="karta")
	private List<Rezervacije> rezervacijes;

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

	public Projekcija getProjekcija() {
		return this.projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public List<Rezervacije> getRezervacijes() {
		return this.rezervacijes;
	}

	public void setRezervacijes(List<Rezervacije> rezervacijes) {
		this.rezervacijes = rezervacijes;
	}

	public Rezervacije addRezervacije(Rezervacije rezervacije) {
		getRezervacijes().add(rezervacije);
		rezervacije.setKarta(this);

		return rezervacije;
	}

	public Rezervacije removeRezervacije(Rezervacije rezervacije) {
		getRezervacijes().remove(rezervacije);
		rezervacije.setKarta(null);

		return rezervacije;
	}

}