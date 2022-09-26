package com.globo.producao.apoio.dtos.requests;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramRequestDTO implements Serializable {

    @NotEmpty
    private String name;

}
