package com.globo.producao.apoio.controllers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.globo.producao.apoio.services.interfaces.ProgramService;

import javax.validation.Valid;

@RestController
@RequestMapping("/support/rest/api/v1")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @GetMapping(value = "/listProgram")
    public ResponseEntity<Page<ProgramResponseDto>> listProgram(){

        return null;
    }

    @PostMapping(value = "/program", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramResponseDto> insert(@Valid @RequestBody final ProgramRequestDto
                                                     programRequestDto)throws Exception{

        return null;
    }


}
