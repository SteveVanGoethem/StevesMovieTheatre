package be.vdab.stevesmovietheatre.controllers;

import be.vdab.stevesmovietheatre.domain.Mandje;
import be.vdab.stevesmovietheatre.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
;
import java.util.Optional;

@Controller
@RequestMapping("/mandje")
public class MandjeController {

    private final FilmService filmService;

    private final Mandje mandje;

    public MandjeController(FilmService filmService, Mandje mandje) {
        this.filmService = filmService;
        this.mandje = mandje;
    }

    @PostMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id){
        mandje.add(id);
        return "redirect:/mandje";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(Optional<Long[]> id){
        id.ifPresent(ids -> mandje.delete(ids));
        return "redirect:/mandje";
    }

    @GetMapping
    public ModelAndView showMandje(){
        var modelAndView = new ModelAndView("mandje");
            modelAndView.addObject("films", filmService.findFilmsByIds(mandje.getFilms()));
        return modelAndView;
    }
}
