package com.globo.producao.apoio.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime reviewDate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private Duration duration;

    private Program program;

    private Agency agency;

    private Client client;

    private Product product;

    private Boolean payTVFlag;

}
