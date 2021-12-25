package com.globo.producao.apoio.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.models.Client;
import com.globo.producao.apoio.models.Product;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.models.enums.TypeActionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionRequestDTO implements Serializable {

    private TypeActionEnum typeAction;

    private String description;

    @JsonIgnore
    private LocalDateTime reviewDate = LocalDateTime.now();

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private ProgramRequestDto program;

    private AgencyRequestDTO agency;

    private ClientRequestDTO client;

    private ProductRequestDTO product;

    private Boolean payTVFlag;

}
