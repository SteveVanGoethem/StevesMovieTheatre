package be.vdab.stevesmovietheatre.controllers;

import be.vdab.stevesmovietheatre.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class FilmController {

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    private final FilmService filmService;

    @GetMapping("film/{id}")
    public ModelAndView showFilmById(@PathVariable long id){
        var modelAndView = new ModelAndView("film");
        modelAndView.addObject("film", filmService.findFilmById(id));
        return modelAndView;
    }
}
