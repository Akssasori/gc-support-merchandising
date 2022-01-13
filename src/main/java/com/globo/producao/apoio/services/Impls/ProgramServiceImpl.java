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
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    @Override
    public Program save(final Program program) throws InsertDataException {

        try {

            Optional<Program> programDB = programRepository.findByName(program.getName());

            if (programDB.isPresent()) {

                if (!program.getName().isEmpty() && Objects.equals(programDB.get().getName().trim().toUpperCase(),
                        program.getName().trim().toUpperCase())) {
                    return programDB.get();
                } else {
                    program.setName(program.getName());
                    return programRepository.save(program);
                }
            } else {

                if (!program.getName().trim().isEmpty()) {
                    program.setName(program.getName().toUpperCase());
                    return programRepository.save(program);

                } else {

                    return null;
                }

            }

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

        if (Objects.equals(programDB.getName().trim().toUpperCase(), program.getName().trim().toUpperCase())) {

            return programDB;

        } else {

            programDB.setName(program.getName().toUpperCase());
            programDB.setId(id);
            return programRepository.save(programDB);

        }

    }

    @Override
    public Program findByProgram(String name) {

        return programRepository.findByName(name.trim().toUpperCase()).orElseThrow(() -> new NoEntityException(name));
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
