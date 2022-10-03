package be.vdab.stevesmovietheatre.domain;

import java.math.BigDecimal;

public record Film(long id, long genreId, String titel, int voorraad, int gereserveerd, BigDecimal prijs) {
}
