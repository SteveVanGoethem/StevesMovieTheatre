package be.vdab.stevesmovietheatre.services;

import be.vdab.stevesmovietheatre.domain.Film;
import be.vdab.stevesmovietheatre.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public List<Film> findFilmsByIds(Set<Long> ids){
        if (ids.isEmpty()) {
            return List.of();
        }else{
            return filmRepository.findFilmsByIds(ids);
        }
    }

    public void addReservedToFilms(Set<Long> ids){
        filmRepository.addReservedToFilms(ids);
    }
}
