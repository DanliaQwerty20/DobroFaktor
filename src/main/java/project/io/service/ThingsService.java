package project.io.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.io.model.Things;
import project.io.repository.ThingsRepository;

import java.util.List;

@Service
public class ThingsService {

    @Autowired
    private ThingsRepository thingsRepository;

    public List<Things> searchThingsByName(String name) {
        return thingsRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Things> getAllThings() {
        return thingsRepository.findAll();
    }
}
