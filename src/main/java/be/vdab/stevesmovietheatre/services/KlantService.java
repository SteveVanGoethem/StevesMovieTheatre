package be.vdab.stevesmovietheatre.services;

import be.vdab.stevesmovietheatre.domain.Klant;
import be.vdab.stevesmovietheatre.repositories.KlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KlantService {

    private final KlantRepository klantRepository;

    public KlantService(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    public List<Klant> findKlantListByName(String name){
       return klantRepository.findKlantListByName(name);
    }

    public Optional<Klant> findKlantById(long id){
        return klantRepository.findKlantById(id);
    }
}
