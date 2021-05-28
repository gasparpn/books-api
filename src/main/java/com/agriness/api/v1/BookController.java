package com.agriness.api.v1;


import com.agriness.book.dto.BookDTO;
import com.agriness.book.entity.Book;
import com.agriness.book.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {this.bookRepository = bookRepository;}

    @GetMapping(value = "")
    @ResponseBody
    public List<BookDTO> getBooks(){
        Iterable<Book> books = bookRepository.findAll();
        List<BookDTO> booksDTO = new ArrayList<>();
        books.forEach( book -> {
            booksDTO.add(BookDTO.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .status(book.getStatus())
                    .lastRentDate(book.getLastRentDate())
                    .client_id(book.getClient().getId())
                    .build());
        });
        return booksDTO;
    }
}
