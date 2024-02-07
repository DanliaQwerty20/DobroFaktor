package project.io.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.io.repository.UserRepository;
import project.io.model.User;
@RestController
@Slf4j
@RequestMapping("/security")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        try {
            boolean flag = false;
            for(User tempUser : userRepository.findAll()){
                if(user.getEmail().equals(tempUser.getEmail()) && user.getPassword().equals(tempUser.getPassword())){
                    flag = true;
                    return ResponseEntity.ok(tempUser);
                }
            }
            if(!flag){
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


