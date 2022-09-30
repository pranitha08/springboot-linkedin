package com.example.demo1.Services;

import com.example.demo1.Repository.LoginRepository;
import com.example.demo1.entity.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginServices {
    @Autowired
    LoginRepository loginRepository;


    public Login getById(Integer id) {
        return loginRepository.findById(id).get();
    }


    public Login registerUser(Login login) {
        return loginRepository.save(login);
    }

    public Login fetchUserByEmail(String email){
        return loginRepository.findByEmail(email);
    }

    public Login fetchUserByEmailAndPassWord(String email, String password){
        return loginRepository.findByEmailAndPassword(email,password);
    }

    public void deleteProfile(Integer id) {
        loginRepository.deleteById(id);
    }
}
