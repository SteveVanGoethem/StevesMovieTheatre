package be.vdab.stevesmovietheatre.controllers;

import be.vdab.stevesmovietheatre.domain.Mandje;
import be.vdab.stevesmovietheatre.forms.KlantForm;
import be.vdab.stevesmovietheatre.services.FilmService;
import be.vdab.stevesmovietheatre.services.KlantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("klant")
public class KlantController {

    private final KlantService klantService;
    private final FilmService filmService;
    private final Mandje mandje;


    public KlantController(KlantService klantService, FilmService filmService, Mandje mandje) {
        this.klantService = klantService;
        this.filmService = filmService;
        this.mandje = mandje;
    }

    @GetMapping("")
    public ModelAndView showKlanten(@Valid KlantForm form){
        var modelAndView = new ModelAndView("klant");
        modelAndView.addObject("klanten", klantService.findKlantListByName(form.name()));
        return modelAndView;
    }

    @GetMapping("/bevestig/{id}")
    public ModelAndView confirmOrder(@PathVariable long id){
        var modelAndView = new ModelAndView("bevestig");
        mandje.setKlantId(id);
        klantService.findKlantById(id).ifPresent(klant -> modelAndView.addObject(klant)
                                                                      .addObject("films", mandje.getFilms()));
        return modelAndView;
    }
}
