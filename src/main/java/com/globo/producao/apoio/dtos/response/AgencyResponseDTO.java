package com.globo.producao.apoio.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgencyResponseDTO implements Serializable {

    private Long id;
    private String name;
    private Long idSiscom;

}
