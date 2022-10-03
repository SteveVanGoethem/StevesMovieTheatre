package be.vdab.stevesmovietheatre.repositories;

import be.vdab.stevesmovietheatre.domain.Film;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmRepository {

    private final JdbcTemplate template;

    public FilmRepository(JdbcTemplate template) {
        this.template = template;
    }

    public RowMapper<Film> filmRowMapper = (rs, rowNum) ->  new Film(
            rs.getLong("id"),
            rs.getLong("genreId"),
            rs.getString("titel"),
            rs.getInt("voorraad"),
            rs.getInt("gereserveerd"),
            rs.getBigDecimal("prijs")
    );

    public List<Film> findFilmsByGenreId(long id){
        var sql = """
                SELECT id, genreId, titel, voorraad, gereserveerd, prijs
                FROM films
                WHERE genreId = ?
                """;
        return template.query(sql, filmRowMapper, id);
    }

    public Film findFilmById(long id){
        var sql = """
                SELECT id, genreId, titel, voorraad, gereserveerd, prijs
                FROM films
                WHERE id = ?
                """;

        return template.queryForObject(sql, filmRowMapper, id);
        }
}
