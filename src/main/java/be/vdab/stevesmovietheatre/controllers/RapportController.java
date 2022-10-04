package be.vdab.stevesmovietheatre.controllers;

import be.vdab.stevesmovietheatre.domain.Mandje;
import be.vdab.stevesmovietheatre.services.FilmService;
import be.vdab.stevesmovietheatre.services.ReservatieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("")
public class RapportController {

    private final FilmService filmService;
    private final ReservatieService reservatieService;
    private final Mandje mandje;

    public RapportController(FilmService filmService, ReservatieService reservatieService, Mandje mandje) {
        this.filmService = filmService;
        this.reservatieService = reservatieService;
        this.mandje = mandje;
    }

    @GetMapping("/rapport")
    public ModelAndView createUpdateShow(){
        var modelAndView = new ModelAndView("rapport");
        var films = filmService.findFilmsByIds(mandje.getFilms());
        var availableFilms = films.stream().filter(film -> (film.voorraad() - film.gereserveerd() > 0)).map(film -> film.id()).collect(Collectors.toSet());
        var unavailableFilms = films.stream().filter(film -> (film.voorraad() - film.gereserveerd() <= 0)).collect(Collectors.toList());
        if(unavailableFilms.isEmpty()){
            filmService.addReservedToFilms(availableFilms);
            reservatieService.create(mandje.getKlantId(), availableFilms);
            mandje.emptyCart();
            modelAndView.addObject("resFilms", List.of());
        }
        else{
            modelAndView.addObject("resFilms", unavailableFilms);
        }
        return modelAndView;
    }
}
