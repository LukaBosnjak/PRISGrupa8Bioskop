package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFilma;

	private int brPutaOcenjen;

	private String linkTrejlera;

	private String naziv;

	private double ocena;

	private String opis;

	private String poster;

	private String uloge;

	private String zanr;

	public Film() {
	}

	public int getIdFilma() {
		return this.idFilma;
	}

	public void setIdFilma(int idFilma) {
		this.idFilma = idFilma;
	}

	public int getBrPutaOcenjen() {
		return this.brPutaOcenjen;
	}

	public void setBrPutaOcenjen(int brPutaOcenjen) {
		this.brPutaOcenjen = brPutaOcenjen;
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

	public double getOcena() {
		return this.ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
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

}