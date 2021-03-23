package com.example.jpa_demo_ali_0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public void addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
