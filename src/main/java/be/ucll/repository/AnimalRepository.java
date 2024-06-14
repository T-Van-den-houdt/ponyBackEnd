package be.ucll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
}
