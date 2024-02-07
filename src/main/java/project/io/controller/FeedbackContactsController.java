package project.io.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.io.model.FeedbackContacts;
import project.io.repository.FeedbackContactsRepository;

@RestController
@Slf4j
@RequestMapping("/contacts")
@CrossOrigin(origins = "http://localhost:5173")
public class FeedbackContactsController {
    @Autowired
    private FeedbackContactsRepository feedbackContactsRepository;

    @PostMapping("/create")
    public ResponseEntity<FeedbackContacts> createUser(@RequestBody FeedbackContacts contacts) {
        try {
            FeedbackContacts saveAns = feedbackContactsRepository.save(contacts);
            System.out.println("Новое сообщение в бд!");
            return ResponseEntity.ok(saveAns);
        }catch (Exception e){
            log.info("Вылезла ошибка: "+ e);
            return null;
        }
    }
}
