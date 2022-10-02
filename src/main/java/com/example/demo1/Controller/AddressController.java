package com.example.demo1.Controller;
import com.example.demo1.Service.AddressService;
import com.example.demo1.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping(value = "/{id}")
    public Address getAddress(@PathVariable Integer id) {
        return addressService.getAddress(id);
    }


    @PostMapping("/post/{id}")
    public Address createAddress(@PathVariable Integer id,@RequestBody Address address) {
        return addressService.createAddress(id,address);
    }

    @PutMapping("/put/{id}")
    public Address updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        return addressService.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}
