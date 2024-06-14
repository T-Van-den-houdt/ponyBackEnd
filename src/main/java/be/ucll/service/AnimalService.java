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
}
