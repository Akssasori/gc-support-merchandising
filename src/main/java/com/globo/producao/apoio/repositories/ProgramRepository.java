package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {


}



