package com.agriness.book.dto;
import com.agriness.book.entity.Book;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookDTO {

    private Long id;

    private String title;

    private Book.Status status;

    private LocalDateTime lastRentDate;

    private Long client_id;

    public static List<BookDTO> fromListBookToListBookDTO(Iterable<Book> books){
        List<BookDTO> booksDTO = new ArrayList<>();
        books.forEach( book -> { booksDTO.add(BookDTO.fromBookToBookDTO(book)); });
        return booksDTO;
    }

    public static BookDTO fromBookToBookDTO(Book book){
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .status(book.getStatus())
                .lastRentDate(book.getLastRentDate())
                .client_id(book.getClient().getId())
                .build();
    }
}
