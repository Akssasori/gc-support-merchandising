package com.globo.producao.apoio.controllers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.mappers.ProgramMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.messages.LocaleContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@Slf4j
@RequestMapping("/support/rest/api/v1")
public class ProgramController {

    @Autowired
    private ProgramService programService;


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


}
