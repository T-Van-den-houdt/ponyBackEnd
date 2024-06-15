package be.ucll.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.Stable;
import be.ucll.service.StabelService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/stables")
public class StabelRestController {
    
    private StabelService stabelService;

    public StabelRestController(StabelService stabelService) {
        this.stabelService = stabelService;
    }

    @GetMapping()
    public List<Stable> getAllStabels() {
        return stabelService.getAllStabels();
    }

    @GetMapping("/withAnimals")
    public List<Stable> getAllStablesWithAnimals() {
        return stabelService.getAllStabelsWithAnimals();
    }

    @GetMapping("/{animalName}")
    public Stable getStableWithAnimal(@PathVariable String animalName) {
        return stabelService.getStableWithAnimal(animalName);
    }
    
    
}
