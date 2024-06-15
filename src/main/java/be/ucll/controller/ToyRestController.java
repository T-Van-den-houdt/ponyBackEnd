package be.ucll.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.Animal;
import be.ucll.model.Toy;
import be.ucll.service.ToyService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/toys")
public class ToyRestController {
    
    private ToyService toyService;

    public ToyRestController(ToyService toyService) {
        this.toyService = toyService;
    }

    @PostMapping()
    public Toy addToy(@Valid @RequestBody Toy toy) {
        return toyService.addToy(toy);
    }

    @PostMapping("/{animalId}")
    public Animal addToyToAnimal(@Valid @RequestBody Toy toy, @PathVariable Long animalId) {
        return toyService.addToyToAnimal(toy, animalId);
    }

    @GetMapping("/{name}")
    public List<Toy> getToysWithName(@PathVariable String name) {
        return toyService.getToysWithName(name);
    }
    
    
}
