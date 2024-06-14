package be.ucll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.Animal;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
    List<Animal> findByAgeEquals(int age);
    
    Animal findTopByOrderByAgeDesc();

    Animal findByNameEquals(String name);

    Boolean existsByName(String name);
}
