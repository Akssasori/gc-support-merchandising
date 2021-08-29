package com.globo.producao.apoio.controllers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.mappers.ProgramMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.messages.LocaleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

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

    /**
     * API GET:listAllProgram, Return an ResponseEntity object with the
     * list of filtered creatives.
     *
     * @param program program
     * @return returns a ResponseEntity object with the list
     * programResponseDtoList
     * @see ResponseEntity
     */

    @GetMapping(value = "/listProgram")
    public ResponseEntity<List<ProgramResponseDto>> listAllProgram( Program program)
            throws FindAllDataException {

        List<Program> programList = programService.findAll();

        List<ProgramResponseDto> programResponseDtoList =
                ProgramMapper.INSTANCE.programListToProgramResponseDtoList(programList);

        if(programResponseDtoList.isEmpty() || programResponseDtoList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            log.info(LocaleContext.format("response.success",
                    (new Object() {
                    }.getClass().getEnclosingMethod().getName()),
                    HttpStatus.CREATED.toString()));

            return status(HttpStatus.CREATED).body(programResponseDtoList);
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


//    @PutMapping(value = "/edit-program/{id}")
//    public ResponseEntity<ProgramResponseDto> updateProgramById(
//            @Valid @RequestBody final ProgramRequestDto programRequestDto,
//            @PathVariable final Long id) throws FindDataException, InsertDataException {
//
//        Program program = programService.findById(id);
//
//        ProgramResponseDto programResponseDto = null;
//
//        if(Objects.nonNull(program) & program.getId() != 0 ) {
//
//                programService.insert(ProgramMapper.INSTANCE.programRequestDtoToProgram(programRequestDto));
//
//                programResponseDto = ProgramMapper.INSTANCE.programToProgramResponseDTO(program);
//
//                log.info(LocaleContext.format("response.success",
//                        (new Object() {
//                        }.getClass().getEnclosingMethod().getName()),
//                        HttpStatus.CREATED.toString()));
//
//        } else {
//
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//
//        return status(HttpStatus.OK).body(programResponseDto);
//    }

    @PutMapping(value = "/edit-program/{id}")
    public ResponseEntity<ProgramResponseDto> updateProgramById(
            @Valid @RequestBody final ProgramRequestDto programRequestDto,
            @PathVariable final Long id) throws FindDataException, InsertDataException {

        Program program = programService.findById(id);

        ProgramResponseDto programResponseDto = new ProgramResponseDto();

        BeanUtils.copyProperties(programRequestDto, program);

        BeanUtils.copyProperties(program, programResponseDto);

        programService.insert(program);

            log.info(LocaleContext.format("response.success",
                    (new Object() {
                    }.getClass().getEnclosingMethod().getName()),
                    HttpStatus.OK.toString()));


        return status(HttpStatus.OK).body(programResponseDto);

        }



}
