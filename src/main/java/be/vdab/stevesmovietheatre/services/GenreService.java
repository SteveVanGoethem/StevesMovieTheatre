package be.vdab.stevesmovietheatre.services;

import be.vdab.stevesmovietheatre.domain.Genre;
import be.vdab.stevesmovietheatre.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAllGenres(){
        return genreRepository.findAllGenres();
    }
}
