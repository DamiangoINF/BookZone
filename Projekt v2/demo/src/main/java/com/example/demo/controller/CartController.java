package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.CartItemRequest;
import com.example.demo.model.Book;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

    // Pobierz wszystkie pozycje z koszyka
    @GetMapping
    public List<Cart> getCartItems() {
        return cartRepository.findAll();
    }

    // Dodaj nową pozycję do koszyka
    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        // Sprawdź, czy książka istnieje
        Book book = bookRepository.findById(cart.getBookId())
                .orElseThrow(() -> new RuntimeException("Książka nie znaleziona"));

        // Ustaw tytuł i cenę książki w koszyku
        cart.setBookTitle(book.getTitle());
        cart.setBookPrice(book.getPrice());

        // Zapisz pozycję w koszyku
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    // Zwiększ ilość książek w pozycji koszyka
    @PostMapping("/increase")
    public ResponseEntity<?> increaseQuantity(@RequestBody CartItemRequest request) {
        Optional<Cart> cartItem = cartRepository.findById(request.getBookId());
        if (cartItem.isPresent()) {
            Cart item = cartItem.get();
            item.setQuantity(item.getQuantity() + 1); // Zwiększ ilość
            cartRepository.save(item);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pozycja nie znaleziona w koszyku");
        }
    }

    // Zmniejsz ilość książek w pozycji koszyka
    @PostMapping("/decrease")
    public ResponseEntity<?> decreaseQuantity(@RequestBody CartItemRequest request) {
        Optional<Cart> cartItem = cartRepository.findById(request.getBookId());
        if (cartItem.isPresent()) {
            Cart item = cartItem.get();
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1); // Zmniejsz ilość
                cartRepository.save(item);
                return ResponseEntity.ok().build();
            } else {
                // Jeśli ilość jest 1, usuń pozycję z koszyka
                cartRepository.delete(item);
                return ResponseEntity.ok().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pozycja nie znaleziona w koszyku");
        }
    }

    // Usuń pozycję z koszyka
    @PostMapping("/remove")
    public ResponseEntity<?> removeFromCart(@RequestBody CartItemRequest request) {
        Optional<Cart> cartItem = cartRepository.findById(request.getBookId());
        if (cartItem.isPresent()) {
            Cart item = cartItem.get();
            cartRepository.delete(item); // Usuń pozycję z koszyka
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pozycja nie znaleziona w koszyku");
        }
    }

    // Aktualizuj ilość książek w pozycji koszyka
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCartItemQuantity(@PathVariable Long id, @RequestBody Cart cart) {
        return cartRepository.findById(id)
                .map(existingCart -> {
                    // Zaktualizuj ilość książek
                    existingCart.setQuantity(cart.getQuantity());
                    return ResponseEntity.ok(cartRepository.save(existingCart));
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // Jeśli pozycja nie istnieje, zwróć 404
    }

    // Usuń pozycję z koszyka (alternatywna metoda)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        cartRepository.deleteById(id); // Usuń pozycję z koszyka
        return ResponseEntity.noContent().build(); // Zwróć status 204 (No Content)
    }
}