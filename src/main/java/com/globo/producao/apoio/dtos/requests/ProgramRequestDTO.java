package com.globo.producao.apoio.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramRequestDTO implements Serializable {

    /**
     * Program name.
     */
    private String name;

}
