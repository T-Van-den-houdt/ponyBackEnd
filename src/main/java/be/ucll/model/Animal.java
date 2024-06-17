package be.ucll.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "species", discriminatorType = DiscriminatorType.STRING)
@Table(name = "MY_ANIMALS")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty(message="Name is required.")
    private String name;

    @NotNull(message="Age is required.")
    @Min(value = 1, message="Age must be a positive integer between 1 and 50")
    @Max(value = 50, message="Age must be a positive integer between 1 and 50")
    private int age;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "MY_STABLES_ID")
    private Stable stable;

    @ManyToMany(mappedBy = "owningAnimals")
    private Set<Toy> toys = new HashSet<>();

    @OneToMany(mappedBy = "animal")
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    public Animal(String name, int age) {
        setName(name);
        setAge(age);
    }

    protected Animal() {
        
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Stable getStable() {
        return stable;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    public Set<Toy> getToys() {
        return toys;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }
}
