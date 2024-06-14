package be.ucll.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.Animal;
import be.ucll.service.AnimalService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/animals")
public class AnimalRestController {

    private AnimalService animalService;

    public AnimalRestController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping()
    public Animal addAnimal(@Valid @RequestBody Animal animal) {
       return animalService.addAnimal(animal);
    }
    
}
