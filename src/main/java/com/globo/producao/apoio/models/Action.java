package com.globo.producao.apoio.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globo.producao.apoio.models.enums.TypeActionEnum;
import lombok.*;

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

    @JsonFormat(pattern = "HH:mm:ss")
    private Duration duration;

    @OneToOne(mappedBy = "action", fetch = FetchType.LAZY)
    private Client client;

    @OneToOne(mappedBy = "action", fetch = FetchType.LAZY)
    private Program program;

    @OneToOne(mappedBy = "action", fetch = FetchType.LAZY)
    private Product product;

    @OneToOne(mappedBy = "action", fetch = FetchType.LAZY)
    private Agency agency;

    private Boolean payTVFlag;


}
