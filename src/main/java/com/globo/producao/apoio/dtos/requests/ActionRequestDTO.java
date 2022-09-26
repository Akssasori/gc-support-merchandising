package com.globo.producao.apoio.dtos.requests;

import com.globo.producao.apoio.models.enums.TypeActionEnum;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionRequestDTO implements Serializable {

    private TypeActionEnum typeAction;

    private String description;

    private LocalDateTime reviewTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private ProgramRequestDTO program;

    private AgencyRequestDTO agency;

    private ClientRequestDTO client;

    private ProductRequestDTO product;

    private Boolean payTVFlag;

}
