package be.vdab.stevesmovietheatre.repositories;

import be.vdab.stevesmovietheatre.domain.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository {

    private final JdbcTemplate template;

    public GenreRepository(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<Genre> genreRowMapper = (rs, rowNum) -> new Genre(
            rs.getString("naam"),
            rs.getLong("id")
    );

    public List<Genre> findAllGenres(){
        var sql = """
                SELECT naam, id
                FROM genres
                """;
       return template.query(sql, genreRowMapper);
    }
}
