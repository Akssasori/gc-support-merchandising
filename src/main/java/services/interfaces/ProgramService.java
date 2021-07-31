package services.interfaces;

import dtos.response.ProgramResponseDto;
import models.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import utils.exceptions.FindAllDataException;

public interface ProgramService {

    /**
     * Insert and return the creative inserted.
     *
     * @param program creative data to insert
     * @return return a creative inserted
     * @see Program
     */
    Program listAll(Program program) throws FindAllDataException;


    /**
     * Returns paged list of programs.
     *
     * @param programResponseDto dto of programs
     * @param pageable pagination data
     * @return list of programs
     * @see Page <Program>
     */
    Page<Program> findByPrograms(
            ProgramResponseDto programResponseDto, Pageable pageable
    ) throws FindAllDataException;
}
