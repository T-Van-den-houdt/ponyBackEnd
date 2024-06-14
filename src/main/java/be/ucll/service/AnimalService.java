package be.ucll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import be.ucll.model.Animal;
import be.ucll.repository.AnimalRepository;

@Service
public class AnimalService {
    
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal addAnimal(Animal animal) {
        
        List<Animal> animals = animalRepository.getAnimals();
        if (!animals.contains(animal)) {
            animalRepository.addAnimal(animal);
        } else {
            throw new ServiceException("This name is already in the database");
        }
        
        List<Animal> newAnimals = animalRepository.getAnimals();
        System.out.println(newAnimals);
        for(Animal a : newAnimals) {
            if (a.equals(animal)) {
                return a;
            }
        }
        throw new ServiceException("Something went wrong: animal has not been added");
    }
}
