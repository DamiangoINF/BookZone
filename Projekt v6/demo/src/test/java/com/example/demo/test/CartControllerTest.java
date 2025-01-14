package com.example.demo.test;


import com.example.demo.controller.CartController;
import com.example.demo.model.Book;
import com.example.demo.model.Cart;
import com.example.demo.model.CartItemRequest;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CartControllerTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private CartController cartController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddToCart() {
        // Arrange
        Cart cart = new Cart();
        cart.setBookId(1L);
        cart.setQuantity(1);

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Book 1");
        book.setPrice(10.0);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(cartRepository.save(cart)).thenReturn(cart);

        // Act
        ResponseEntity<?> response = cartController.addToCart(cart);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(bookRepository, times(1)).findById(1L);
        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    void testIncreaseQuantity() {
        // Arrange
        CartItemRequest request = new CartItemRequest();
        request.setBookId(1L);

        Cart cart = new Cart();
        cart.setBookId(1L);
        cart.setQuantity(1);

        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(cartRepository.save(cart)).thenReturn(cart);

        // Act
        ResponseEntity<?> response = cartController.increaseQuantity(request);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(cartRepository, times(1)).findById(1L);
        verify(cartRepository, times(1)).save(cart);
    }
}