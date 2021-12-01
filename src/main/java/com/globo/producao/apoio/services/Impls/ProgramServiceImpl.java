package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.repositories.ProgramRepository;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    @Override
    public Program save(final Program program) throws InsertDataException {
        try {
            return programRepository.save(program);
        } catch (Exception e) {
            throw new InsertDataException(e.getMessage());
        }
    }

    @Override
    public List<Program> findAll() throws FindAllDataException {
        try {
            return programRepository.findAll();
        } catch (Exception e) {
            throw new FindAllDataException(e.getMessage());
        }
    }

    @Override
    public Program findById(Long id) throws FindDataException {
        try {
            return programRepository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));
        } catch (Exception e) {
            throw new FindDataException(e.getMessage());
        }
    }

    @Override
    public Program Update(Long id, Program program) throws UpdateDataException {

        Program programDB = programRepository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));

        try {
            programDB.setProgram(program.getProgram());
            programDB.setId(id);
            return programRepository.save(programDB);
        } catch (Exception e) {
            throw new UpdateDataException(e.getMessage());
        }

    }

    @Override
    public void Delete(Long id) throws DeleteDataException {
        try {
            if (programRepository.existsById(id)) {
                programRepository.deleteById(id);
            } else {
                ResponseEntity.notFound();
            }
        } catch (Exception e) {
            throw new DeleteDataException(e.getMessage());
        }
    }

    @Override
    public Page<Program> pageProgram(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return programRepository.findAll(pageable);
    }


}
