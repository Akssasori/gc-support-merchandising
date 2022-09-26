package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.models.Program;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

    @EntityGraph(attributePaths = {"action"})
    Optional<Program> findByName(String name);


}



