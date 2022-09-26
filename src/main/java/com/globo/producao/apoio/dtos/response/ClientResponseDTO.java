package com.globo.producao.apoio.dtos.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {

    private Long id;
    private String name;
    private Long idSiscom;
}
