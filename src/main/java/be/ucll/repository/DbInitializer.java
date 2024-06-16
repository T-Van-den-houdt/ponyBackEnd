package be.ucll.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import be.ucll.model.Address;
import be.ucll.model.Animal;
import be.ucll.model.MedicalRecord;
import be.ucll.model.Stable;
import be.ucll.model.Toy;

@Component
public class DbInitializer {
    
    private AnimalRepository animalRepository;
    private StableRepository stableRepository;
    private AddressRepository addressRepository;
    private ToyRepository toyRepository;
    private MedicalRecordRepository medicalRecordRepository;

    public DbInitializer(AnimalRepository animalRepository, StableRepository stableRepository, AddressRepository addressRepository, ToyRepository toyRepository, MedicalRecordRepository medicalRecordRepository) {
        this.animalRepository = animalRepository;
        this.stableRepository = stableRepository;
        this.addressRepository = addressRepository;
        this.toyRepository = toyRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @PostConstruct
    public void Initialize() {

        Animal animal1 = new Animal("Bella", 20);
        Animal animal2 = new Animal("Luna", 10);
        Animal animal3 = new Animal("Muriel", 2);
        Animal animal4 = new Animal("Little", 1);

        animalRepository.save(animal1);
        animalRepository.save(animal2);
        animalRepository.save(animal3);
        animalRepository.save(animal4);

        Stable stable1 = new Stable("stblHN", 5);
        Stable stable2 = new Stable("PonyCO", 3);

        Address address1 = new Address("Ucll-straat", 69, "Haasrode");
        Address address2 = new Address("WidowmakerOverwatchStraat", 420, "Leuven");

        Toy toy1 = new Toy("Ball");
        toy1.addAnimal(animal2);
        animal2.addToy(toy1);
        toyRepository.save(toy1);
        animalRepository.save(animal2);

        MedicalRecord medicalRecord1 = new MedicalRecord(LocalDate.of(2001, 9, 11), "Aids");
        medicalRecord1.setAnimal(animal1);
        animal1.setMedicalRecord(medicalRecord1);
        animalRepository.save(animal1);
        medicalRecordRepository.save(medicalRecord1);

        stable1.setAddress(address1);
        stable2.setAddress(address2);

        stable1.addAnimal(animal2);
        stable2.addAnimal(animal3);

        addressRepository.save(address1);
        addressRepository.save(address2);
        stableRepository.save(stable1);
        stableRepository.save(stable2);
        animalRepository.save(animal2);
        animalRepository.save(animal3);
    }
}
