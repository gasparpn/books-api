package com.agriness.book.entity;

import com.agriness.client.entity.Client;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Book {

    public enum Status {
        DISPONIVEL, EMPRESTADO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    @Builder.Default
    private Status status = Status.DISPONIVEL;

    private LocalDateTime lastRentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
}
