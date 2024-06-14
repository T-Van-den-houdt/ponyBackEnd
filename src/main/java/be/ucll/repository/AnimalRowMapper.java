package be.ucll.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import be.ucll.model.Animal;

public class AnimalRowMapper implements RowMapper<Animal>{
    @Override
    public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Animal(rs.getString("NAME"), rs.getInt("AGE"));
    }
}