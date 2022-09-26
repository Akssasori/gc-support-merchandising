package com.globo.producao.apoio.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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
    private Set<Action> action;



}
