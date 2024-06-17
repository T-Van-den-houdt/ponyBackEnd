package be.ucll.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Pony")
public class Pony extends Animal{
    
    protected Pony() {

    }

    public Pony(String name, int age) {
        super(name, age);
    }
}
