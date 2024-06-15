package be.ucll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
