package com.example.demo1.Services;

import com.example.demo1.Repository.AddressRepository;
import com.example.demo1.Repository.ProfileRepository;
import com.example.demo1.entity.Address;

import com.example.demo1.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServices {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ProfileRepository profileRepository;


    public Address getAddress(Integer id) {
        return addressRepository.findById(id).get();
    }



    public Address createAddress(Integer id,Address address) {
        Address address1=addressRepository.save(address);
        Profile profile=profileRepository.findById(id).get();
        profile.setAddress_id(address1);
        profileRepository.save(profile);
        return address1;
    }

    public Address updateAddress(Integer id, Address address) {
        Address oldAddress=addressRepository.findById(id).orElse(null);
        if(oldAddress!=null){
            oldAddress.setStreet(address.getStreet());
            oldAddress.setCity(address.getCity());
            oldAddress.setState(address.getState());
            oldAddress.setCountry(address.getCountry());
            oldAddress.setPin_code(address.getPin_code());
            return addressRepository.save(oldAddress);
        }
        return null;
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}
