package com.globo.producao.apoio.dtos.response;

import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.models.Client;
import com.globo.producao.apoio.models.Product;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.models.enums.TypeActionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionResponseDTO implements Serializable {

    private Long id;

    private TypeActionEnum typeAction;

    private String description;

    private LocalDateTime reviewDate;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Duration duration;

//    private ProgramResponseDto program;

    private AgencyResponseDTO agency;

//    private ClientResponseDTO client;
//
//    private ProductResponseDTO product;

    private Boolean payTVFlag;

}
