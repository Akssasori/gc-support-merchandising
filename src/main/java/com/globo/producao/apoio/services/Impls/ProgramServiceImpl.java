package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.repositories.ProgramRepository;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImpl implements ProgramService {

    /**
     * Program repository.
     */
    @Autowired
    private ProgramRepository programRepository;

    @Override
    public Program insert(final Program program) throws InsertDataException {
        try{

            return programRepository.save(program);

        }catch (Exception e){
            throw new InsertDataException(e.getMessage());
        }
    }




}
