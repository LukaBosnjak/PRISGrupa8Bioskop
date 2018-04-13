package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Film;

@Remote
public interface FilmoviBeanRemote {
	public Film nadijFilm(int id);
	public List<Film> izlistajFilmovePoZanru(String zanr);
}
