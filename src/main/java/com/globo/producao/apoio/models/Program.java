package com.globo.producao.apoio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Program implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Program not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Action> action;




}
