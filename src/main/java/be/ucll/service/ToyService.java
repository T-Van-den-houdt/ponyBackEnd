package be.ucll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.ucll.model.Animal;
import be.ucll.model.Toy;
import be.ucll.repository.AnimalRepository;
import be.ucll.repository.ToyRepository;

@Service
public class ToyService {
    
    private ToyRepository toyRepository;
    private AnimalRepository animalRepository;

    public ToyService(ToyRepository toyRepository, AnimalRepository animalRepository) {
        this.toyRepository = toyRepository;
        this.animalRepository = animalRepository;
    }

    public Toy addToy(Toy toy) {
        toyRepository.save(toy);
        return toyRepository.findById(toy.getId()).get();
    }

    public Animal addToyToAnimal(Toy toy, Long animalId) {
        if (animalRepository.existsById(animalId)) {
            Animal animal = animalRepository.findById(animalId).get();
            animal.addToy(toy);
            toy.addAnimal(animal);
            toyRepository.save(toy);
            animalRepository.save(animal);
            return animalRepository.findById(animalId).get();
        } else {
            throw new ServiceException("Animal doesn't exist");
        }
    }

    public List<Toy> getToysWithName(String name) {
        List<Toy> result = new ArrayList<>();
        for (Toy toy : toyRepository.findAll()) {
            if (toy.getName().equals(name)) {
                result.add(toy);
            }
        }
        return result;
    }   
}
