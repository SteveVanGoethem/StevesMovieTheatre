package be.vdab.stevesmovietheatre.services;

import be.vdab.stevesmovietheatre.domain.Film;
import be.vdab.stevesmovietheatre.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findFilmsByGenreId(long id){
        return filmRepository.findFilmsByGenreId(id);
    }

    public Film findFilmById(long id){
        return filmRepository.findFilmById(id);
    }
}
