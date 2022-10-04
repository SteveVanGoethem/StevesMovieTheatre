package be.vdab.stevesmovietheatre.repositories;

import be.vdab.stevesmovietheatre.domain.Klant;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class KlantRepository {

    private final JdbcTemplate template;

    public KlantRepository(JdbcTemplate template) {
        this.template = template;
    }

    public RowMapper<Klant> klantRowMapper = (rs, rowNum) -> new Klant(
            rs.getLong("id"),
            rs.getString("familienaam"),
            rs.getString("voornaam"),
            rs.getString("straatNummer"),
            rs.getInt("postcode"),
            rs.getString("gemeente")
    );

    public List<Klant>findKlantListByName(String name){
        var sql = """
                SELECT id, familienaam, voornaam, straatNummer, postcode, gemeente
                FROM klanten
                WHERE familienaam LIKE '%""" + name +
                "%' ORDER BY familienaam";
                return template.query(sql, klantRowMapper);
    }

    public Optional<Klant> findKlantById(long id){
        try{
            var sql = """
                SELECT id, familienaam, voornaam, straatNummer, postcode, gemeente
                FROM klanten
                WHERE id = ?
                """;
            return Optional.of(
                    template.queryForObject(sql, klantRowMapper, id));

        } catch(IncorrectResultSizeDataAccessException e){
            return Optional.empty();
        }


    }
}
