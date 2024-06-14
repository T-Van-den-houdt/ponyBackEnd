package be.ucll.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import be.ucll.model.Animal;

@Repository
public class AnimalRepository {
    
    private JdbcTemplate jdbcTemplate;

    public AnimalRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Animal> getAnimals() {
        return jdbcTemplate.query("SELECT * FROM MY_ANIMALS", new AnimalRowMapper());
    }

    public void addAnimal(Animal animal) {
        jdbcTemplate.update("INSERT INTO MY_ANIMALS (NAME, AGE) VALUES (?, ?)", animal.getName(), animal.getAge());
    }
}
