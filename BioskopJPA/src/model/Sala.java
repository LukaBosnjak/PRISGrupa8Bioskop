package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSale;

	private int brMesta;

	private int brSale;

	//bi-directional many-to-one association to Projekcija
	@OneToMany(mappedBy="sala")
	private List<Projekcija> projekcijas;

	public Sala() {
	}

	public int getIdSale() {
		return this.idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public int getBrMesta() {
		return this.brMesta;
	}

	public void setBrMesta(int brMesta) {
		this.brMesta = brMesta;
	}

	public int getBrSale() {
		return this.brSale;
	}

	public void setBrSale(int brSale) {
		this.brSale = brSale;
	}

	public List<Projekcija> getProjekcijas() {
		return this.projekcijas;
	}

	public void setProjekcijas(List<Projekcija> projekcijas) {
		this.projekcijas = projekcijas;
	}

	public Projekcija addProjekcija(Projekcija projekcija) {
		getProjekcijas().add(projekcija);
		projekcija.setSala(this);

		return projekcija;
	}

	public Projekcija removeProjekcija(Projekcija projekcija) {
		getProjekcijas().remove(projekcija);
		projekcija.setSala(null);

		return projekcija;
	}

}