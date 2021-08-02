package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.models.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;

public interface ProgramService {


    /**
     * Returns paged list of programs.
     *
     * @param programResponseDto dto of programs
     * @param pageable pagination data
     * @return list of programs
     * @see Page <Program>
     */
    Page<Program> listPageAll(
            ProgramRequestDto programResponseDto, Pageable pageable
    ) throws FindAllDataException;
}
