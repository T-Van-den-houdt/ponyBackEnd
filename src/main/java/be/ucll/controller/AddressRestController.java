package be.ucll.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.Address;
import be.ucll.model.Stable;
import be.ucll.service.AddressService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/address")
public class AddressRestController {
    
    private AddressService addressService;

    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping()
    public Address addAddress(@Valid @RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @PostMapping("/stable")
    public Stable postStableWithAddress(@Valid @RequestBody Stable stable) {
        return addressService.addStableWithAddress(stable);
    }
    
    @PostMapping("/{addressId}/{stableId}")
    public Stable postAddAdressToStable(@PathVariable Long addressId, @PathVariable Long stableId) {
        return addressService.addAddressToStable(addressId, stableId);
    }
    
}
