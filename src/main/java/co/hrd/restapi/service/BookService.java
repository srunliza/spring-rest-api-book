package co.hrd.restapi.service;


import co.hrd.restapi.dto.BookDto;
import co.hrd.restapi.entity.Book;
import co.hrd.restapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by id
    public Optional<Book> getBookById(Long id) {
        if (bookRepository.existsById(id)) {
            return bookRepository.findById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Book with id %s not found", id));
        }
    }

    // Insert new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Update book by id
    public Book updateBook(Long id, BookDto bookDto) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(bookDto.title());
                    existingBook.setAuthor(bookDto.author());
                    existingBook.setIsbn(bookDto.isbn());
                    return bookRepository.save(existingBook);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found"));
    }

    // Delete book by id
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Book with id %s not found", id));
        }
    }


}
