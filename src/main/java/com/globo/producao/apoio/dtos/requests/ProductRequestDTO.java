package com.globo.producao.apoio.dtos.requests;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO implements Serializable {

    private String name;

}
