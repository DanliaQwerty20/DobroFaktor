package project.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.io.model.DTO.CartItemDTO;
import project.io.model.FeedbackContacts;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemDTO, Long> {
    void deleteAll();

}
