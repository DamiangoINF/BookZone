package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Book;
import com.example.demo.model.CartItemRequest;
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
    public ResponseEntity<?> addToCart(@RequestBody Cart cart) {
        // Sprawdź, czy książka istnieje
        Book book = bookRepository.findById(cart.getBookId())
                .orElseThrow(() -> new RuntimeException("Książka nie znaleziona"));

        // Ustaw tytuł i cenę książki w koszyku
        cart.setBookTitle(book.getTitle());
        cart.setBookPrice(book.getPrice());

        // Sprawdź, czy łączna liczba książek w koszyku nie przekracza 5
        int totalBooksInCart = getTotalBooksInCart();
        if (totalBooksInCart + cart.getQuantity() > 5) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Możesz mieć tylko 5 książek w koszyku.");
        }

        // Zapisz pozycję w koszyku
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    // Zwiększ ilość książek w pozycji koszyka
    @PostMapping("/increase")
    public ResponseEntity<?> increaseQuantity(@RequestBody CartItemRequest request) {
        Optional<Cart> cartItem = cartRepository.findById(request.getBookId());
        if (cartItem.isPresent()) {
            Cart item = cartItem.get();

            // Sprawdź, czy łączna liczba książek w koszyku nie przekracza 5
            int totalBooksInCart = getTotalBooksInCart();
            if (totalBooksInCart + 1 > 5) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Możesz mieć tylko 5 książek w koszyku.");
            }

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

    // Metoda pomocnicza do zliczania łącznej liczby książek w koszyku
    private int getTotalBooksInCart() {
        List<Cart> cartItems = cartRepository.findAll();
        return cartItems.stream().mapToInt(Cart::getQuantity).sum();
    }
    @PostMapping("/clear")
    public ResponseEntity<?> clearCart() {
        cartRepository.deleteAll(); // Usuń wszystkie pozycje z koszyka
        return ResponseEntity.ok().build();
    }
}