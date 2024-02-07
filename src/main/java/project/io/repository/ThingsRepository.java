package project.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.io.model.FeedbackContacts;
import project.io.model.Things;

import java.util.List;

@Repository
public interface ThingsRepository extends JpaRepository<Things, Long> {
    List<Things> findByNameContainingIgnoreCase(String name);
}
