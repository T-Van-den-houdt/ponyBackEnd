package be.ucll.repository;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import be.ucll.model.Animal;

@Component
public class DbInitializer {
    
    private AnimalRepository animalRepository;

    public DbInitializer(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostConstruct
    public void Initialize() {

        Animal animal1 = new Animal("Bella", 20);
        Animal animal2 = new Animal("Luna", 10);
        Animal animal3 = new Animal("Muriel", 2);
        Animal animal4 = new Animal("Little", 1);

        animalRepository.save(animal1);
        animalRepository.save(animal2);
        animalRepository.save(animal3);
        animalRepository.save(animal4);
    }
}
