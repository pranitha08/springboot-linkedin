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
        return loginService.registerUser(login);
    }

    @PostMapping("/login")
    public Login loginUser(@RequestBody Login login) throws Exception {
       return loginService.loginUser(login);
    }

    @GetMapping(value = "/{id}")
    public Login getUser(@PathVariable Integer id) {
        return loginService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        loginService.deleteProfile(id);
    }
}
