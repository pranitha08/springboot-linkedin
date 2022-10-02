package com.example.demo1.Controller;
import com.example.demo1.Service.LoginService;
import com.example.demo1.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/register")
    public Login registerUser(@RequestBody Login login) throws Exception {
        String tempEmailId = login.getEmail();
        if (tempEmailId != null) {
            Login loginObj = loginService.fetchUserByEmail(tempEmailId);
            if (loginObj != null) {
                throw new Exception("User With " + tempEmailId + " is already exist");
            }
        }
        return loginService.registerUser(login);
    }

    @PostMapping("/login")
    public Login loginUser(@RequestBody Login login) throws Exception {
        String tempEmailId = login.getEmail();
        String tempPassword = login.getPassword();
        Login loginObj = null;
        if (tempEmailId != null && tempPassword != null) {
            loginObj = loginService.fetchUserByEmailAndPassWord(tempEmailId, tempPassword);
        }
        if (loginObj == null) {
            throw new Exception("Bad Credentials");
        }
        return loginObj;
    }

    @GetMapping(value = "/{id}")
    public Login getById(@PathVariable Integer id) {
        return loginService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        loginService.deleteProfile(id);
    }
}
