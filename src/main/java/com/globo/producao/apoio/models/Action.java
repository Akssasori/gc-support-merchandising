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

    private LocalDateTime reviewDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

//    @JsonFormat(pattern = "HH:mm:ss")
    private Duration duration;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "program_id")
//    private Program program;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;

    private Boolean payTVFlag;


}
