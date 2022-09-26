package com.globo.producao.apoio.controllers;


import com.globo.producao.apoio.dtos.requests.AgencyRequestDTO;
import com.globo.producao.apoio.dtos.requests.ClientRequestDTO;
import com.globo.producao.apoio.dtos.response.AgencyResponseDTO;
import com.globo.producao.apoio.dtos.response.ClientResponseDTO;
import com.globo.producao.apoio.mappers.AgencyMapper;
import com.globo.producao.apoio.mappers.ClientMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.AgencyService;
import com.globo.producao.apoio.services.interfaces.ClientService;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("agency")
@RequiredArgsConstructor
public class AgencyController {

    private final AgencyService service;

    private final AgencyMapper mapper;

    @GetMapping
    public ResponseEntity<List<AgencyResponseDTO>> getAgencies() {

        return status(HttpStatus.OK).body(mapper.agencyListToAgencyResponseDTO(new HashSet<>(service.findAll())));

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AgencyResponseDTO> getAgencyById
            (@PathVariable final Long id){

        return status(HttpStatus.OK).body(mapper.agencyToAgencyResponseDTO(service.findById(id)));

    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AgencyResponseDTO> createAgency
            (@Valid @RequestBody final AgencyRequestDTO agencyRequestDTO) throws InsertDataException {

        return status(HttpStatus.CREATED).body(mapper.agencyToAgencyResponseDTO(
                service.save(mapper.agencyRequestDTOToAgency(agencyRequestDTO))));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgencyResponseDTO> updateAgencyById (
            @PathVariable(value = "id") final Long id,
            @Valid @RequestBody final AgencyRequestDTO agencyRequestDTO){

        return status(HttpStatus.OK).body(mapper.agencyToAgencyResponseDTO
                (service.update(id, mapper.agencyRequestDTOToAgency(agencyRequestDTO))));

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Program> deleteAgency (
            @PathVariable(value = "id") final Long id) {

        service.delete(id);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/siscom/{idSiscom}")
    public ResponseEntity<AgencyResponseDTO> getAgencyByIdSiscom
            (@PathVariable final Long idSiscom){

        return ResponseEntity.status(HttpStatus.OK).body(mapper.agencyToAgencyResponseDTO(service.findByIdSiscom(idSiscom)));

    }

//    @GetMapping(value = "/page/{pageNumber}/{pageSize}")
//    public Page<ProgramResponseDto> pagePrograms(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
//
//        return mapper.programToProgramResponseDTOPage(programService.pageProgram(pageNumber,pageSize));
//    }







}
