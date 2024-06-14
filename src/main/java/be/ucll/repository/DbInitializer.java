package be.ucll.repository;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import be.ucll.model.Animal;
import be.ucll.model.Stable;

@Component
public class DbInitializer {
    
    private AnimalRepository animalRepository;
    private StableRepository stableRepository;

    public DbInitializer(AnimalRepository animalRepository, StableRepository stableRepository) {
        this.animalRepository = animalRepository;
        this.stableRepository = stableRepository;
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

        Stable stable1 = new Stable("stblHN", 5);
        Stable stable2 = new Stable("PonyCO", 3);


        stable1.addAnimal(animal2);
        stable2.addAnimal(animal3);

        stableRepository.save(stable1);
        stableRepository.save(stable2);
        animalRepository.save(animal2);
        animalRepository.save(animal3);
    }
}
