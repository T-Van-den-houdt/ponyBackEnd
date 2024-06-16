package be.ucll.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "MY_MEDICAL_RECORDS")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @PastOrPresent(message = "Registration date cannot be in the future.")
    private LocalDate registrationDate;

    private LocalDate closingDate;

    @NotBlank(message = "A description is required")
    private String description;

    @ManyToOne
    @JoinColumn(name = "MY_ANIMALS_ID")
    private Animal animal;

    public MedicalRecord(LocalDate registrationDate, String description)  {
        setRegistrationDate(registrationDate);
        setDescription(description);
        this.closingDate = null;
    }

    protected MedicalRecord() {

    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        if (closingDate.isBefore(registrationDate.plusDays(1))) {
            throw new DomainException("Closing date needs to be at least one day after registration date");
        }
        this.closingDate = closingDate; 
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
