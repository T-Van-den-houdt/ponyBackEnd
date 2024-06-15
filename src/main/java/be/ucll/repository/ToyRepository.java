package be.ucll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.ucll.model.Toy;

public interface ToyRepository extends JpaRepository<Toy, Long>{

    Toy findByNameEquals(String name);
}
