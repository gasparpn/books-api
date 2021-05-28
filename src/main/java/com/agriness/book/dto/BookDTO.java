package com.agriness.book.dto;
import com.agriness.book.entity.Book;
import lombok.*;

import java.time.LocalDateTime;

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
}
