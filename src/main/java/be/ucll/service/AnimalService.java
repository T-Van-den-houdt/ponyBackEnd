package be.ucll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import be.ucll.model.Animal;
import be.ucll.model.Stable;
import be.ucll.repository.AnimalRepository;
import be.ucll.repository.StableRepository;

@Service
public class AnimalService {
    
    private AnimalRepository animalRepository;
    private StableRepository stableRepository;

    public AnimalService(AnimalRepository animalRepository, StableRepository stableRepository) {
        this.animalRepository = animalRepository;
        this.stableRepository = stableRepository;
    }

    public Animal addAnimal(Animal animal) {
        
        List<Animal> animals = animalRepository.findAll();
        if (!animals.contains(animal)) {
            animalRepository.save(animal);
        } else {
            throw new ServiceException("This name is already in the database");
        }
        
        if(animalRepository.existsById(animal.getId())) {
            return animal;
        }
        throw new ServiceException("Something went wrong! Try again");
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public List<Animal> getAnimalsByAge(int age) {
        return animalRepository.findByAgeEquals(age);
    }

    public Animal getOldestAnimal() {
        return animalRepository.findTopByOrderByAgeDesc();
    }

    public Stable addAnimalToNewStable(String animalName, Stable stable) {
        if(animalRepository.existsByName(animalName)) {
            Animal animal = animalRepository.findByNameEquals(animalName);
            stable.addAnimal(animal);
            stableRepository.save(stable);
            animalRepository.save(animal);
            return stableRepository.findById(stable.getId()).get();
        } else {
            throw new ServiceException("The animal doesn't exist.");
        }
    }

    public Stable postAddAnimalToExistingStable(String animalName, Long stableId) {
        if (animalRepository.existsByName(animalName)) {
            Animal animal = animalRepository.findByNameEquals(animalName);
            Stable stable = stableRepository.findById(stableId).get();
            stable.addAnimal(animal);
            stableRepository.save(stable);
            animalRepository.save(animal);
            return stableRepository.findById(stable.getId()).get();
        } else {
            throw new ServiceException("The animal doesn't exist.");
        }
    }
}
