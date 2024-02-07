package project.io.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.io.model.DTO.CartItemDTO;

import project.io.service.CartItemService;

import java.util.List;
//реализация корзины
@RestController
@Slf4j
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestBody CartItemDTO cartItemDto) {
        try {
            cartItemService.addToCart(cartItemDto);
            log.info("Сохранение в козину произведено в бд!");
        }catch (Exception e){
            log.info("Вылезла ошибка: "+ e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeAllFromCart() {
        cartItemService.removeAllFromCart();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CartItemDTO>> getAllThings() {
        List<CartItemDTO> thingsList = cartItemService.getAllCartItemDTO();
        return new ResponseEntity<>(thingsList, HttpStatus.OK);
    }
}