package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.repositories.ProgramRepository;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    @Override
    public Program Update(ProgramRequestDto programRequestDto) throws UpdateDataException {

        Program program = null;

        try {

            Optional<Program> programDB = programRepository.findById(programRequestDto.getId());

            if (programDB.isPresent()) {

                program = programDB.get();

                program.setProgram(programRequestDto.getProgram());
                program.setId(programRequestDto.getId());

                return programRepository.save(program);
            }
        } catch (Exception e){
            throw new UpdateDataException(e.getMessage());

        }
        return null;
    }


}
