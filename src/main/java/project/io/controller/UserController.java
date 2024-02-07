package project.io.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.io.model.FeedbackContacts;
import project.io.model.User;
import project.io.repository.UserRepository;

@Slf4j
@RestController
@RequestMapping("/security")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registration")
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        try {
            log.info("Received registration request: {}", user.toString());


            if (userRepository.existsByEmailOrPhone(user.getEmail(), user.getPhone())) {
                log.error("User registration failed: User with the same email or phone already exists");
                return new ResponseEntity<>(-1L, HttpStatus.BAD_REQUEST);

            }


            User savedUser = userRepository.save(user);
            log.info("User registration successful: {}", savedUser);


            return new ResponseEntity<>(savedUser.getId(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            log.error("User registration failed: Data integrity violation", e);
            return new ResponseEntity<>(-1L, HttpStatus.BAD_REQUEST);
            // Возвращаем -1L в качестве идентификатора, чтобы обозначить ошибку
        } catch (Exception e) {
            log.error("User registration failed", e);
            return new ResponseEntity<>(-1L, HttpStatus.INTERNAL_SERVER_ERROR);
            // Возвращаем -1L в качестве идентификатора, чтобы обозначить ошибку
        }

    }
}