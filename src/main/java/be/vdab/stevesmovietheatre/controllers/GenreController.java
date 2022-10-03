package be.vdab.stevesmovietheatre.controllers;

import be.vdab.stevesmovietheatre.domain.Genre;
import be.vdab.stevesmovietheatre.services.FilmService;
import be.vdab.stevesmovietheatre.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class GenreController {

    private final GenreService genreService;
    private final FilmService filmService;

    String genreNaam;

    public GenreController(GenreService genreService, FilmService filmService) {
        this.genreService = genreService;
        this.filmService = filmService;
    }

    @GetMapping("genres")
    public ModelAndView showGenres(){
        var modelAndView = new ModelAndView("genres");
        modelAndView.addObject("genreList", genreService.findAllGenres());
        return modelAndView;
    }

    @GetMapping("genres/{id}")
    public ModelAndView showFilmsInGenre(@PathVariable long id){
        var modelAndView = new ModelAndView("genres");
        List<Genre> genreList = genreService.findAllGenres();
        modelAndView.addObject("genreList", genreList);
        modelAndView.addObject("filmList", filmService.findFilmsByGenreId(id));


        for(var genre:genreList){
            if(genre.id() == id){
                genreNaam = genre.naam();
            }
        }
        modelAndView.addObject("genreNaam", genreNaam);
        return modelAndView;
    }
}
