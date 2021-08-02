package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.models.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.globo.producao.apoio.repositories.ProgramRepository;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;


public class ProgramServiceImpl implements ProgramService {

    /**
     * Program repository.
     */
    @Autowired
    private ProgramRepository programRepository;

    @Override
    public Page<Program> listPageAll(
            final ProgramRequestDto programRequestDto,
            final Pageable pageable)throws FindAllDataException{
        try{
            return programRepository.listPageAll(programRequestDto, pageable);
        }catch (Exception e){
            throw new FindAllDataException(e.getMessage());
        }

    }



}
