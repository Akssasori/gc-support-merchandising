package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.utils.exceptions.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProgramService {


    Program save(Program program) throws InsertDataException;

    List<Program> findAll() throws FindAllDataException;

    Program findById(Long id) throws FindDataException;

    Program Update(Long id, Program program) throws UpdateDataException;

    void Delete(Long id) throws DeleteDataException;

}
