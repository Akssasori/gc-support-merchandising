package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.utils.exceptions.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProgramService {


    /**
     * Insert and return the creative inserted.
     *
     * @param program program data to insert
     * @return return a program inserted
     * @see Program
     */
    Program insert(Program program) throws InsertDataException;

    /**
     * Returns all program.
     *
     * @return return a list with all programs
     * @see List <Program>
     */
    List<Program> findPrograms() throws FindAllDataException;

    /**
     * Returns all program.
     *
     * @return return a list with all programs
     * @see List <Program>
     */
    Page<Program> findPagePrograms(Pageable pageable) throws FindAllDataException;

    /**
     * Returns a program filtered by id.
     *
     * @param id program id to find
     * @return program filtered of id
     * @see Program
     */
    Program findById(Long id) throws FindDataException;

    /**
     * Returns a program filtered by id.
     *
     * @param programRequestDto program id to find
     * @param id
     * @return program update
     * @see Program
     */
    Program Update(Long id, Program program) throws UpdateDataException;

    /**
     * Delete program filtered bu id.
     *
     * @param id program id to find
     * @see Program
     */
    void Delete(Long id) throws DeleteDataException;

}
