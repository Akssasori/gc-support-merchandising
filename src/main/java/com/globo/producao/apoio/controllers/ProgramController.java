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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/support")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;


    @PostMapping(value = "/program", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramResponseDto> insertProgram
            (@Valid @RequestBody final ProgramRequestDto programRequestDto)throws InsertDataException {

        return ResponseEntity.status(HttpStatus.CREATED).body(ProgramMapper.INSTANCE.programToProgramResponseDTO(
                programService.insert(ProgramMapper.INSTANCE.programRequestDtoToProgram(programRequestDto))));
    }

//    @GetMapping(value = "/page-program")
//    public ResponseEntity<Page<ProgramResponseDto>> pageProgram(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @PageableDefault(sort = "id", direction = Sort.Direction.ASC)
//            final Pageable pageable) throws FindAllDataException{
//
//        Page<Program> programPage = programService.findPagePrograms(pageable);
//
//        Page<ProgramResponseDto> programResponseDtoPage = ProgramMapper.INSTANCE
//                .mapEntityPageIntoDTOPage(pageable,programPage);
//
//        log.info(LocaleContext.format("response.success",
//                (new Object() {
//                }.getClass().getEnclosingMethod().getName()),
//                HttpStatus.OK.toString()));
//
//        return status(HttpStatus.OK).body(programResponseDtoPage);
//
//    }

    @GetMapping(value = "/listProgram")
    public ResponseEntity<List<ProgramResponseDto>> listAllProgram ()
            throws FindAllDataException {

            return ResponseEntity.status(HttpStatus.OK).body(ProgramMapper.INSTANCE
                    .programListToProgramResponseDtoList(programService.listPrograms()));

        }

    @GetMapping(value = "/listProgram/id")
    public ResponseEntity<ProgramResponseDto> getProgramById
            (@RequestParam final Long id) throws FindDataException {

        return ResponseEntity.status(HttpStatus.OK).body(ProgramMapper.INSTANCE
                .programToProgramResponseDTO(programService.findById(id)));

    }

    @PutMapping(value = "/edit-program/{id}")
    public ResponseEntity<ProgramResponseDto> updateProgramById (
            @PathVariable(value = "id") final Long id,
            @Valid @RequestBody final ProgramRequestDto programRequestDto) throws UpdateDataException {

        return ResponseEntity.status(HttpStatus.OK).body(ProgramMapper.INSTANCE.programToProgramResponseDTO
                (programService.Update(id, ProgramMapper.INSTANCE.programRequestDtoToProgram(programRequestDto))));

    }

    @DeleteMapping(value = "/delete-program/{id}")
    public ResponseEntity<Program> deleteProgram (
            @PathVariable(value = "id") final Long id) throws DeleteDataException {

        programService.Delete(id);

        return ResponseEntity.ok().build();

    }

}
