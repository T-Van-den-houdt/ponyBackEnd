package be.ucll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "MY_ADDRESSES")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty(message="Street name is required.")
    private String street;
    
    @NotNull(message="Number is required")
    @Min(value = 1, message="Age must be a positive integer between 1 and 50")
    private int number;

    @NotEmpty(message="Place is required.")
    private String place;

    public Address(String street, int number, String place) {
        setStreet(street);
        setNumber(number);
        setPlace(place);
    }

    protected Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getId() {
        return id;
    }
    
}
