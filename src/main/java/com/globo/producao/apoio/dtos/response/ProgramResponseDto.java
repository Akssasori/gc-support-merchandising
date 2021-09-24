package com.globo.producao.apoio.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramResponseDto {

    /**
     * Program id.
     */
    @JsonIgnore
    private Long id;

    /**
     * Program name.
     */
    private String program;
}
