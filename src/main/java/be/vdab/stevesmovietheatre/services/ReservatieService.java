package be.vdab.stevesmovietheatre.services;

import be.vdab.stevesmovietheatre.repositories.ReservatieRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReservatieService {

    private final ReservatieRepository reservatieRepository;

    public ReservatieService(ReservatieRepository reservatieRepository) {
        this.reservatieRepository = reservatieRepository;
    }

    public void create(long id, Set<Long> filmIds){
        reservatieRepository.create(id, filmIds);
    }
}
