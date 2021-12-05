package com.globo.producao.apoio.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globo.producao.apoio.models.enums.TypeActionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Action implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeActionEnum typeAction;

    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime reviewDate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;

    @JsonFormat(pattern = "HH:mm:ss")
//    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Duration duration;

    @OneToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
