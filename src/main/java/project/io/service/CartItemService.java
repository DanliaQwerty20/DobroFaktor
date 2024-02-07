package project.io.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.io.model.DTO.CartItemDTO;
import project.io.repository.CartItemRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public void addToCart(CartItemDTO cartItemDto) {

        cartItemRepository.save(cartItemDto);
    }

    public void removeAllFromCart() {
        cartItemRepository.deleteAll();
    }
    public List<CartItemDTO> getAllCartItemDTO() {
        return cartItemRepository.findAll();
    }
}
