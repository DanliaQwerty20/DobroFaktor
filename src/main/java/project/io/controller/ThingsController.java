package project.io.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.io.model.Things;
import project.io.repository.ThingsRepository;
import project.io.service.ThingTestService;
import project.io.service.ThingsService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/things")
@CrossOrigin(origins = "http://localhost:5173")
public class ThingsController {

    @Autowired
    ThingsService thingsService;
    @Autowired
    ThingTestService thingsTestService;


    @GetMapping("/catalog")
    public ResponseEntity<List<Things>> getCatalog() {
        try {
            Calendar calendar = new GregorianCalendar(2017, 0 , 25);
            System.out.println(calendar.getTime());
            List<Things> thingsList = thingsService.getAllThings();
            return new ResponseEntity<>(thingsList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error getting catalog", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/search")
    public ResponseEntity<List<Things>> searchThingsByName(@RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Things> result = thingsService.searchThingsByName(name);
        if (result.isEmpty()) {
            log.info("No such thing!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Successful response");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/all")
    public ResponseEntity<List<Things>> getAllThings() {
        List<Things> thingsList = thingsService.getAllThings();
        return new ResponseEntity<>(thingsList, HttpStatus.OK);
    }
}
