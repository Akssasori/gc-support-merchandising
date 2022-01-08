package com.globo.producao.apoio.controllers;


import com.globo.producao.apoio.dtos.requests.ProgramRequestDTO;
import com.globo.producao.apoio.dtos.response.ProgramResponseDTO;
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
@RequestMapping("program")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService service;

    private final ProgramMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProgramResponseDTO>> getPrograms() throws FindAllDataException {

        return status(HttpStatus.OK).body(mapper
                .programListToProgramResponseDtoList(service.findAll()));

    }

    @GetMapping("{id}")
    public ResponseEntity<ProgramResponseDTO> getProgramById
            (@PathVariable final Long id) throws FindDataException {

        return status(HttpStatus.OK).body(mapper
                .programToProgramResponseDTO(service.findById(id)));

    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramResponseDTO> saveProgram
            (@Valid @RequestBody final ProgramRequestDTO programRequestDto)throws InsertDataException {

        return status(HttpStatus.CREATED).body(mapper.programToProgramResponseDTO(
                service.save(mapper.programRequestDtoToProgram(programRequestDto))));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProgramResponseDTO> updateProgramById (
            @PathVariable(value = "id") final Long id,
            @Valid @RequestBody final ProgramRequestDTO programRequestDto) throws UpdateDataException {

        return status(HttpStatus.OK).body(mapper.programToProgramResponseDTO
                (service.Update(id, mapper.programRequestDtoToProgram(programRequestDto))));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Program> deleteProgram (
            @PathVariable(value = "id") final Long id) throws DeleteDataException {

        service.Delete(id);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/page/{pageNumber}/{pageSize}")
    public Page<ProgramResponseDTO> pagePrograms(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){

        return mapper.programToProgramResponseDTOPage(service.pageProgram(pageNumber,pageSize));
    }







}
