package com.example.demo1.Controller;
import com.example.demo1.Services.AddressServices;
import com.example.demo1.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressServices addressServices;

    @GetMapping(value = "/{id}")
    public Address getAddress(@PathVariable Integer id) {
        return addressServices.getAddress(id);
    }


    @PostMapping("/post/{id}")
    public Address createAddress(@PathVariable Integer id,@RequestBody Address address) {
        return addressServices.createAddress(id,address);
    }

    @PutMapping("/put/{id}")
    public Address updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        return addressServices.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressServices.deleteAddress(id);
    }
}
