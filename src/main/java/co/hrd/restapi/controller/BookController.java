package co.hrd.restapi.controller;

import co.hrd.restapi.dto.CreateBookDto;
import co.hrd.restapi.entity.Book;
import co.hrd.restapi.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
@Tag(name = "Book-Controller")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get book by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id) {
       Optional<Book> book = bookService.getBookById(id);
       return book.isPresent() ? ResponseEntity.ok(book.get()) : ResponseEntity.notFound().build();
    }

    // Insert new book
    @PostMapping
    public Book addBook(@RequestBody CreateBookDto createBookDto) {
        return bookService.createBook(createBookDto);
    }

    // Update book by id
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody CreateBookDto createBookDto) {
        return bookService.updateBook(id, createBookDto);
    }

    // Delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
