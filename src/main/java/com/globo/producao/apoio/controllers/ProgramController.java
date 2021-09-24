package com.globo.producao.apoio.controllers;


import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.mappers.ProgramMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.*;
import com.globo.producao.apoio.utils.messages.LocaleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@Slf4j
@RequestMapping("/support/rest/api/v1")
public class ProgramController {

    /**
     * Program Service object used by Program Controller.
     */
    @Autowired
    private ProgramService programService;

    /**
     * API POST: Insert program method.
     *
     * @param programRequestDto
     * @return returns a program inserted.
     * @throws InsertDataException
     */
    @PostMapping(value = "/program", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramResponseDto> insertProgram
            (@Valid @RequestBody final ProgramRequestDto
                                                     programRequestDto)throws InsertDataException {

        Program program = programService.insert(
                ProgramMapper.INSTANCE.programRequestDtoToProgram(
                        programRequestDto));

        ProgramResponseDto programResponseDto =
                ProgramMapper.INSTANCE.programToProgramResponseDTO(
                        program);

        log.info(LocaleContext.format("response.success",
                (new Object() {
                }.getClass().getEnclosingMethod().getName()),
                HttpStatus.CREATED.toString()));

        return status(HttpStatus.CREATED).body(programResponseDto);
    }

    @GetMapping(value = "/page-program")
    public ResponseEntity<Page<ProgramResponseDto>> pageProgram(
            @RequestParam(required = false) final Long id,
            @RequestParam(required = false) final String program,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC)
            final Pageable pageable) throws FindAllDataException{

        Page<Program> programPage = programService.findPagePrograms(pageable);

        Page<ProgramResponseDto> programResponseDtoPage = ProgramMapper.INSTANCE
                .mapEntityPageIntoDTOPage(pageable,programPage);

        log.info(LocaleContext.format("response.success",
                (new Object() {
                }.getClass().getEnclosingMethod().getName()),
                HttpStatus.OK.toString()));

        return status(HttpStatus.OK).body(programResponseDtoPage);

    }

    /**
     * API GET:listAllProgram, Return an ResponseEntity object with the
     * list of filtered creatives.
     *
     * @return returns a ResponseEntity object with the list
     * programResponseDtoList
     * @see ResponseEntity
     */
    @GetMapping(value = "/listProgram")
    public ResponseEntity<List<ProgramResponseDto>> listAllProgram ()
            throws FindAllDataException {

        List<Program> programList = programService.findPrograms();

        List<ProgramResponseDto> programResponseDtoList =
                ProgramMapper.INSTANCE.programListToProgramResponseDtoList(programList);

        if (programResponseDtoList.isEmpty() || programResponseDtoList == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            log.info(LocaleContext.format("response.success",
                    (new Object() {
                    }.getClass().getEnclosingMethod().getName()),
                    HttpStatus.OK.toString()));

            return status(HttpStatus.OK).body(programResponseDtoList);

        }

    }

    /**
     * API GET:listProgram{id}, Return specific program by id
     * The Program id argument is used to search and filter
     * program.
     *
     * @param id program id
     * @return returns a ResponseEntity object with the program select by id
     * @see ResponseEntity
     */
    @GetMapping(value = "/listProgram/id")
    public ResponseEntity<ProgramResponseDto> getProgramById
            (@RequestParam final Long id) throws FindDataException {

        ProgramResponseDto programResponseDto =
                ProgramMapper.INSTANCE.programToProgramResponseDTO(programService.findById(id));

        log.info(LocaleContext.format("response.success",
                (new Object() {
                }.getClass().getEnclosingMethod().getName()),
                HttpStatus.OK.toString()));

        return status(HttpStatus.OK).body(programResponseDto);

    }

    @PutMapping(value = "/edit-program/{id}")
    public ResponseEntity<ProgramResponseDto> updateProgramById (
            @PathVariable(value = "id") final Long id,
            @Valid @RequestBody final ProgramRequestDto programRequestDto) throws UpdateDataException {

        ProgramResponseDto programResponseDto = ProgramMapper.INSTANCE.programToProgramResponseDTO(
                programService.Update(programRequestDto));

        log.info(LocaleContext.format("response.success",
                (new Object() {
                }.getClass().getEnclosingMethod().getName()),
                HttpStatus.OK.toString()));

        return status(HttpStatus.OK).body(programResponseDto);

    }

    @DeleteMapping(value = "/delete-program/{id}")
    public ResponseEntity<?> deleteProgram (
            @PathVariable(value = "id") final Long id) throws DeleteDataException {

        programService.Delete(id);

        log.info(LocaleContext.format("response.success",
                (new Object() {
                }.getClass().getEnclosingMethod().getName()),
                HttpStatus.OK.toString()));

        return ResponseEntity.ok().build();

    }

}
