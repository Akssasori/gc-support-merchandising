package com.globo.producao.apoio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long idSiscom;

//    @OneToOne
//    @JoinColumn(name = "action_id")
//    private Action action;

    @OneToOne(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Action action;



}
