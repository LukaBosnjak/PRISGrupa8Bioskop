package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projekcija database table.
 * 
 */
@Entity
@NamedQuery(name="Projekcija.findAll", query="SELECT p FROM Projekcija p")
public class Projekcija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProjekcije;

	private double cena;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String tip;

	//bi-directional many-to-one association to Karta
	@OneToMany(mappedBy="projekcija")
	private List<Karta> kartas;

	//bi-directional many-to-one association to Film
	@ManyToOne
	private Film film;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	private Sala sala;

	//bi-directional many-to-one association to Rezervacije
	@OneToMany(mappedBy="projekcija")
	private List<Rezervacije> rezervacijes;

	public Projekcija() {
	}

	public int getIdProjekcije() {
		return this.idProjekcije;
	}

	public void setIdProjekcije(int idProjekcije) {
		this.idProjekcije = idProjekcije;
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

	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Karta> getKartas() {
		return this.kartas;
	}

	public void setKartas(List<Karta> kartas) {
		this.kartas = kartas;
	}

	public Karta addKarta(Karta karta) {
		getKartas().add(karta);
		karta.setProjekcija(this);

		return karta;
	}

	public Karta removeKarta(Karta karta) {
		getKartas().remove(karta);
		karta.setProjekcija(null);

		return karta;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Rezervacije> getRezervacijes() {
		return this.rezervacijes;
	}

	public void setRezervacijes(List<Rezervacije> rezervacijes) {
		this.rezervacijes = rezervacijes;
	}

	public Rezervacije addRezervacije(Rezervacije rezervacije) {
		getRezervacijes().add(rezervacije);
		rezervacije.setProjekcija(this);

		return rezervacije;
	}

	public Rezervacije removeRezervacije(Rezervacije rezervacije) {
		getRezervacijes().remove(rezervacije);
		rezervacije.setProjekcija(null);

		return rezervacije;
	}

}