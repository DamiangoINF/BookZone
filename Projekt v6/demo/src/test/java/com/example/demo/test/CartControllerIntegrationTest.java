package com.example.demo.test;



import com.example.demo.model.Book;
import com.example.demo.model.Cart;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class) // Dodajemy rozszerzenie Mockito
class CartControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private BookRepository bookRepository;

    @TestConfiguration // Konfiguracja testowa dla mocków
    static class TestConfig {
        @Bean
        public CartRepository cartRepository() {
            return mock(CartRepository.class);
        }

        @Bean
        public BookRepository bookRepository() {
            return mock(BookRepository.class);
        }
    }

    @Test
    void testAddToCart() throws Exception {

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Book 1");
        book.setPrice(10.0);

        Cart cart = new Cart();
        cart.setBookId(1L);
        cart.setQuantity(1);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(cartRepository.save(cart)).thenReturn(cart);

        // Act & Assert
        mockMvc.perform(post("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"bookId\": 1, \"quantity\": 1}"))
                .andExpect(status().isOk());
    }
}