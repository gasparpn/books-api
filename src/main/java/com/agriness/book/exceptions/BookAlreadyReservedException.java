package com.agriness.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Book already reserved for other client")
public class BookAlreadyReservedException extends RuntimeException{
}
