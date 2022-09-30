package com.example.demo1.Controller;
import com.example.demo1.Services.LoginServices;
import com.example.demo1.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    LoginServices loginServices;

    @PostMapping("/register")
    public Login registerUser(@RequestBody Login login) throws Exception {
        String tempEmailId = login.getEmail();
        if (tempEmailId != null) {
            Login loginObj = loginServices.fetchUserByEmail(tempEmailId);
            if (loginObj != null) {
                throw new Exception("User With " + tempEmailId + " is already exist");
            }
        }
        return loginServices.registerUser(login);
    }

    @PostMapping("/login")
    public Login loginUser(@RequestBody Login login) throws Exception {
        String tempEmailId = login.getEmail();
        String tempPassword = login.getPassword();
        Login loginObj = null;
        if (tempEmailId != null && tempPassword != null) {
            loginObj = loginServices.fetchUserByEmailAndPassWord(tempEmailId, tempPassword);
        }
        if (loginObj == null) {
            throw new Exception("Bad Credentials");
        }
        return loginObj;
    }

    @GetMapping(value = "/{id}")
    public Login getById(@PathVariable Integer id) {
        return loginServices.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        loginServices.deleteProfile(id);
    }
}
