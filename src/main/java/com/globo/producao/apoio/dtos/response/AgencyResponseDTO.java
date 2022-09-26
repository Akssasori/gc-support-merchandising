package com.globo.producao.apoio.dtos.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgencyResponseDTO implements Serializable {

    private Long id;
    private String name;
    private Long idSiscom;

}
