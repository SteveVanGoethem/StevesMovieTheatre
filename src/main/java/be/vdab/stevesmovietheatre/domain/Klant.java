package be.vdab.stevesmovietheatre.domain;

public record Klant(long id, String familienaam, String voornaam, String straatNummer, int postcode, String gemeente) {
}
