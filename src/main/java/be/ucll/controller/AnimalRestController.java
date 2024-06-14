package be.ucll.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.Animal;
import be.ucll.model.Stable;
import be.ucll.service.AnimalService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/animals")
public class AnimalRestController {

    private AnimalService animalService;

    public AnimalRestController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }

    @GetMapping("/{age}")
    public List<Animal> getAnimalsByAge(@PathVariable int age) {
        return animalService.getAnimalsByAge(age);
    }
    
    @GetMapping("/oldest")
    public Animal getOldestAnimal() {
        return animalService.getOldestAnimal();
    }
    
    @PostMapping()
    public Animal addAnimal(@Valid @RequestBody Animal animal) {
       return animalService.addAnimal(animal);
    }

    @PostMapping("/{animalName}/stable")
    public Stable postAddAnimalToNewStable(@PathVariable String animalName, @Valid @RequestBody Stable stable) {
        return animalService.addAnimalToNewStable(animalName, stable);
    }
    
    @PostMapping("{animalName}")
    public Stable postAddAnimalToExistingStable(@PathVariable String animalName, @Valid @PathVariable(required = true) Long stableId) {
        return animalService.postAddAnimalToExistingStable(animalName, stableId);
    }
}
