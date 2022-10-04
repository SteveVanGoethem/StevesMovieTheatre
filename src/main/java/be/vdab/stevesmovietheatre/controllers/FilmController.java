package be.vdab.stevesmovietheatre.controllers;

import be.vdab.stevesmovietheatre.domain.Film;
import be.vdab.stevesmovietheatre.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    /*@PostMapping("film/addToCart")
    public String addFilmToCart(@ModelAttribute Film film, Error errors, HttpSession session){

        var films = (List<Film>) session.getAttribute("films");
        boolean filmExists = false;
        for(var filmObj:films){
            if(film.id() == filmObj.id()){
                filmExists = true;
            }
        }
        if(filmExists == false){
            films.add(film);
        }
        session.setAttribute("films", films);
        return "/addTo";
    }*/
}
