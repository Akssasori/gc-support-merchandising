package com.globo.producao.apoio.dtos.response;

import com.globo.producao.apoio.models.enums.TypeActionEnum;
import lombok.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionResponseDTO implements Serializable {

    private Long id;

    private TypeActionEnum typeAction;

    private String description;

    private LocalDateTime reviewTime;

    private LocalDateTime updateTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Duration duration;

    private ProgramResponseDTO program;

    private AgencyResponseDTO agency;

    private ClientResponseDTO client;

    private ProductResponseDTO product;

    private Boolean payTVFlag;

}
