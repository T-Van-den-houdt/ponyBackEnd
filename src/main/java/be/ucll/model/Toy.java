package be.ucll.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "MY_TOYS")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message="Name is required.")
    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "TOYS_OWNED_BY",
        joinColumns = @JoinColumn(name = "MY_TOYS_ID"),
        inverseJoinColumns = @JoinColumn(name = "MY_ANIMALS_ID")
    )
    private Set<Animal> owningAnimals = new HashSet<>();

    public Toy(String name) {
        setName(name);
    }

    protected Toy() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAnimal(Animal animal) {
        owningAnimals.add(animal);
    }

    public long getId() {
        return id;
    }

    public Set<Animal> getOwningAnimals() {
        return owningAnimals;
    }
    
}
