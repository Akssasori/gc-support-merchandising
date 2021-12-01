package com.globo.producao.apoio.controllers;


import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.mappers.ProgramMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/program")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    private final ProgramMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProgramResponseDto>> getPrograms() throws FindAllDataException {

        return status(HttpStatus.OK).body(mapper
                .programListToProgramResponseDtoList(programService.findAll()));

    }

    @GetMapping(value = "/listProgram/id")
    public ResponseEntity<ProgramResponseDto> getProgramById
            (@RequestParam final Long id) throws FindDataException {

        return status(HttpStatus.OK).body(mapper
                .programToProgramResponseDTO(programService.findById(id)));

    }

    @PostMapping(value = "/program", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramResponseDto> saveProgram
            (@Valid @RequestBody final ProgramRequestDto programRequestDto)throws InsertDataException {

        return status(HttpStatus.CREATED).body(mapper.programToProgramResponseDTO(
                programService.save(mapper.programRequestDtoToProgram(programRequestDto))));
    }

    @PutMapping(value = "/edit-program/{id}")
    public ResponseEntity<ProgramResponseDto> updateProgramById (
            @PathVariable(value = "id") final Long id,
            @Valid @RequestBody final ProgramRequestDto programRequestDto) throws UpdateDataException {

        return status(HttpStatus.OK).body(mapper.programToProgramResponseDTO
                (programService.Update(id, mapper.programRequestDtoToProgram(programRequestDto))));

    }

    @DeleteMapping(value = "/delete-program/{id}")
    public ResponseEntity<Program> deleteProgram (
            @PathVariable(value = "id") final Long id) throws DeleteDataException {

        programService.Delete(id);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/page/{pageNumber}/{pageSize}")
    public Page<ProgramResponseDto> pagePrograms(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){

        return mapper.programToProgramResponseDTOPage(programService.pageProgram(pageNumber,pageSize));
    }







}
