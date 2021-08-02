package com.globo.producao.apoio.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramResponseDto {

    /**
     * Program id.
     */
    private Long id;

    /**
     * Program name.
     */
    private String program;
}
