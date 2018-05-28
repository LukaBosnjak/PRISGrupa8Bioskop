package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnika;

	private int karta_idKarte;

	private String password;

	private String rola;

	@Lob
	private byte[] slika;

	private String username;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="korisnik")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Rezervacije
	@OneToMany(mappedBy="korisnik")
	private List<Rezervacije> rezervacijes;

	public Korisnik() {
	}

	public int getIdKorisnika() {
		return this.idKorisnika;
	}

	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public int getKarta_idKarte() {
		return this.karta_idKarte;
	}

	public void setKarta_idKarte(int karta_idKarte) {
		this.karta_idKarte = karta_idKarte;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRola() {
		return this.rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setKorisnik(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setKorisnik(null);

		return komentar;
	}

	public List<Rezervacije> getRezervacijes() {
		return this.rezervacijes;
	}

	public void setRezervacijes(List<Rezervacije> rezervacijes) {
		this.rezervacijes = rezervacijes;
	}

	public Rezervacije addRezervacije(Rezervacije rezervacije) {
		getRezervacijes().add(rezervacije);
		rezervacije.setKorisnik(this);

		return rezervacije;
	}

	public Rezervacije removeRezervacije(Rezervacije rezervacije) {
		getRezervacijes().remove(rezervacije);
		rezervacije.setKorisnik(null);

		return rezervacije;
	}

}