package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.repositories.ProgramRepository;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Program> findAll() throws FindAllDataException {
        try{
            return programRepository.findAll();
        }catch(Exception e){
            throw new FindAllDataException(e.getMessage());
        }
    }

    @Override
    public Program findById(Long id) throws FindDataException {
        try{
            return programRepository.findById(id).get();
        }catch (Exception e){
            throw new FindDataException(e.getMessage());
        }
    }


}
