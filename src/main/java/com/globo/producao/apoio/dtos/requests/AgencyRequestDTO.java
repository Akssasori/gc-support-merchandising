package com.globo.producao.apoio.dtos.requests;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgencyRequestDTO implements Serializable {

    private String name;
    private Long idSiscom;

}
