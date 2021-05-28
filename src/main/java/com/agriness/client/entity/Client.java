package com.agriness.client.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="client")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
