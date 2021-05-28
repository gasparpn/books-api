package com.agriness.client.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClientDTO {

    private Long id;

    private String name;
}
