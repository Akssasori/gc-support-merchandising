package com.globo.producao.apoio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Action> action;



}
