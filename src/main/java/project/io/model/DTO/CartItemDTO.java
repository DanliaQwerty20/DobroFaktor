package project.io.model.DTO;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cart_items")
@AllArgsConstructor
public class CartItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private int quantity;
    private double price;
    private String name;
    private String image;


}
