package be.ucll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.ucll.model.Animal;
import be.ucll.model.Stable;
import be.ucll.repository.AnimalRepository;
import be.ucll.repository.StableRepository;

@Service
public class StabelService {
    private AnimalRepository animalRepository;
    private StableRepository stableRepository;

    public StabelService(AnimalRepository animalRepository, StableRepository stableRepository) {
        this.animalRepository = animalRepository;
        this.stableRepository = stableRepository;
    }

    public List<Stable> getAllStabels() {
        return stableRepository.findAll();
    }

    public List<Stable> getAllStabelsWithAnimals() {
        List<Stable> result = new ArrayList<>();
        List<Stable> stables = getAllStabels();
        for (Stable stable : stables) {
            if (stable.getAnimals().size() > 0) {
                result.add(stable);
            }
        }
        return result;
    }

    public Stable getStableWithAnimal(String animalName) {
        if (animalRepository.existsByName(animalName)) {
            Animal animal = animalRepository.findByNameEquals(animalName);
            List<Stable> stables = getAllStabels();
            for (Stable stable : stables) {
                if (stable.getAnimals().contains(animal)) {
                    return stable;
                }    
            }
            throw new ServiceException("The animal is not in a stable.");
        } else {
            throw new ServiceException("The animal doesn't exist.");
        }
    }




}
