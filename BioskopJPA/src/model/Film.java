package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Film database table.
 * 
 */
@Entity
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFilma;

	private String linkTrejlera;

	private String naziv;

	private String opis;

	@Lob
	private byte[] poster;

	private String uloge;

	private String zanr;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="film")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Projekcija
	@OneToMany(mappedBy="film")
	private List<Projekcija> projekcijas;

	public Film() {
	}

	public int getIdFilma() {
		return this.idFilma;
	}

	public void setIdFilma(int idFilma) {
		this.idFilma = idFilma;
	}

	public String getLinkTrejlera() {
		return this.linkTrejlera;
	}

	public void setLinkTrejlera(String linkTrejlera) {
		this.linkTrejlera = linkTrejlera;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public byte[] getPoster() {
		return this.poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getUloge() {
		return this.uloge;
	}

	public void setUloge(String uloge) {
		this.uloge = uloge;
	}

	public String getZanr() {
		return this.zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setFilm(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setFilm(null);

		return komentar;
	}

	public List<Projekcija> getProjekcijas() {
		return this.projekcijas;
	}

	public void setProjekcijas(List<Projekcija> projekcijas) {
		this.projekcijas = projekcijas;
	}

	public Projekcija addProjekcija(Projekcija projekcija) {
		getProjekcijas().add(projekcija);
		projekcija.setFilm(this);

		return projekcija;
	}

	public Projekcija removeProjekcija(Projekcija projekcija) {
		getProjekcijas().remove(projekcija);
		projekcija.setFilm(null);

		return projekcija;
	}

}