package be.ucll.service;

import org.springframework.stereotype.Service;

import be.ucll.model.Address;
import be.ucll.model.Stable;
import be.ucll.repository.AddressRepository;
import be.ucll.repository.StableRepository;

@Service
public class AddressService {
    
    private AddressRepository addressRepository;
    private StableRepository stableRepository;

    public AddressService(AddressRepository addressRepository, StableRepository stableRepository) {
        this.addressRepository = addressRepository;
        this.stableRepository = stableRepository;
    }

    public Address addAddress(Address address) {
        addressRepository.save(address);
        return addressRepository.findById(address.getId()).get();
    }

    public Stable addStableWithAddress(Stable stable) {
        if (stable.getAddress() != null) {
            addressRepository.save(stable.getAddress());
            stableRepository.save(stable);
            return stableRepository.findById(stable.getId()).get();
        } else {
            throw new ServiceException("The stable needs to have an address.");
        }
    }

    public Stable addAddressToStable(Long addressId, Long stableId) {
        if (addressRepository.existsById(addressId) && stableRepository.existsById(stableId)) {
            Stable stable = stableRepository.findById(stableId).get();
            Address address = addressRepository.findById(stableId).get();
            stable.setAddress(address);
            stableRepository.save(stable);
            return stableRepository.findById(stableId).get();
        } else {
            throw new ServiceException("The given address/stable Id does not exist.");
        }
    }   

    
}
