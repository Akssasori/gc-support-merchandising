package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Program;

public interface ProgramService {


    /**
     * Insert and return the creative inserted.
     *
     * @param program program data to insert
     * @return return a program inserted
     * @see Program
     */
    Program insert(Program program) throws Exception;

}
