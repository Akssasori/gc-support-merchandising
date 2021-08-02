package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.models.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

    Page<Program> listPageAll(ProgramRequestDto programRequestDto, Pageable pageable);

}



