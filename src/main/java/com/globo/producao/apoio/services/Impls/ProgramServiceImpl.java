package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.repositories.ProgramRepository;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    /**
     * Program repository.
     */
    private final ProgramRepository programRepository;

    @Override
    public Program insert(final Program program) throws InsertDataException {
        try {
            return programRepository.save(program);
        } catch (Exception e) {
            throw new InsertDataException(e.getMessage());
        }
    }

    @Override
    public List<Program> findPrograms() throws FindAllDataException {
        try {
            return programRepository.findAll();
        } catch (Exception e) {
            throw new FindAllDataException(e.getMessage());
        }
    }

    @Override
    public Page<Program> findPagePrograms(Pageable pageable) throws FindAllDataException {
        try {
            return programRepository.findAll(pageable);
        } catch (Exception e) {
            throw new FindAllDataException(e.getMessage());
        }
    }

    @Override
    public Program findById(Long id) throws FindDataException {
        try {
            return programRepository.findById(id).get();
        } catch (Exception e) {
            throw new FindDataException(e.getMessage());
        }
    }

    @Override
    public Program Update(Long id, Program program) throws UpdateDataException {

        Program programDB = programRepository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));

        try {
//            if (Objects.nonNull(programDB)) {
                programDB.setProgram(program.getProgram());
                programDB.setId(id);
//            }
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


}
