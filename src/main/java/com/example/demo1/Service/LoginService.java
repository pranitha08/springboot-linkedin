package com.example.demo1.Service;

import com.example.demo1.Repository.LoginRepository;
import com.example.demo1.entity.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;


    public Login getUser(Integer id) {
        return loginRepository.findById(id).get();
    }


    public Login registerUser(Login login) throws Exception {
        String tempEmailId = login.getEmail();
        if (tempEmailId != null) {
            Login loginObj = loginRepository.findByEmail(tempEmailId);
            if (loginObj != null) {
                throw new Exception("User With " + tempEmailId + " is already exist");
            }
        }
        return loginRepository.save(login);
    }

    public Login loginUser(@RequestBody Login login) throws Exception {
        String tempEmailId = login.getEmail();
        String tempPassword = login.getPassword();
        Login loginObj = null;
        if (tempEmailId != null && tempPassword != null) {
            loginObj =loginRepository.findByEmailAndPassword(tempEmailId, tempPassword);
        }
        if (loginObj == null) {
            throw new Exception("Bad Credentials");
        }
        return loginObj;
    }

    public void deleteProfile(Integer id) {
        loginRepository.deleteById(id);
    }
}
