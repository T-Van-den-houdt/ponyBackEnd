package be.ucll.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "MY_STABLES")
public class Stable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty(message = "Name cannot be empty.")
    private String name;

    @NotNull(message = "maxAnimals is required")
    @Min(value = 1, message = "maxAnimals needs to be positive")
    private int maxAnimals;

    @JsonManagedReference
    @OneToMany(mappedBy = "stable")
    List<Animal> animals = new ArrayList<Animal>();

    @OneToOne
    @JoinColumn(name = "MY_ADDRESSES_ID")
    private Address address;

    public Stable(String name, int maxAnimals) {
        setName(name);
        setMaxAnimals(maxAnimals);
    }
    
    protected Stable() {
        
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public int getMaxAnimals() {
        return maxAnimals;
    }

    public void setMaxAnimals(int maxAnimals) {
        this.maxAnimals = maxAnimals;
    }

    public void addAnimal(Animal animal) {
        if(animals.size() < maxAnimals) {
            animals.add(animal);
            animal.setStable(this);
        } else {
            throw new DomainException("There is no more place in this stable.");
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
