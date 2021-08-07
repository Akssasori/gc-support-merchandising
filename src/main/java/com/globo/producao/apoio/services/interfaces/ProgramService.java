package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;

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
    List<Program> findAll() throws FindAllDataException;

    /**
     * Returns a program filtered by id.
     *
     * @param id program id to find
     * @return program filtered of id
     * @see Program
     */
    Program findById(Long id) throws FindDataException;



}
