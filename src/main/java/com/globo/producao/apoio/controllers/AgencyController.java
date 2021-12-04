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
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/agency")
@RequiredArgsConstructor
public class AgencyController {

    private final AgencyService service;

    private final AgencyMapper mapper;

    @GetMapping
    public ResponseEntity<List<AgencyResponseDTO>> getAgencies() {

        return status(HttpStatus.OK).body(mapper.agencyListToAgencyResponseDTO(service.findAll()));

    }

    @GetMapping(value = "/agency-by/id")
    public ResponseEntity<AgencyResponseDTO> getAgencyById
            (@RequestParam final Long agencyId){

        return status(HttpStatus.OK).body(mapper.agencyToAgencyResponseDTO(service.findById(agencyId)));

    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AgencyResponseDTO> createAgency
            (@Valid @RequestBody final AgencyRequestDTO agencyRequestDTO) {

        return status(HttpStatus.CREATED).body(mapper.agencyToAgencyResponseDTO(
                service.save(mapper.agencyRequestDTOToAgency(agencyRequestDTO))));
    }

    @PutMapping(value = "/edit/{agencyId}")
    public ResponseEntity<AgencyResponseDTO> updateAgencyById (
            @PathVariable(value = "agencyId") final Long agencyId,
            @Valid @RequestBody final AgencyRequestDTO agencyRequestDTO){

        return status(HttpStatus.OK).body(mapper.agencyToAgencyResponseDTO
                (service.update(agencyId, mapper.agencyRequestDTOToAgency(agencyRequestDTO))));

    }

    @DeleteMapping(value = "/delete/{agencyId}")
    public ResponseEntity<Program> deleteAgency (
            @PathVariable(value = "agencyId") final Long agencyId) {

        service.delete(agencyId);

        return ResponseEntity.ok().build();

    }

//    @GetMapping(value = "/page/{pageNumber}/{pageSize}")
//    public Page<ProgramResponseDto> pagePrograms(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
//
//        return mapper.programToProgramResponseDTOPage(programService.pageProgram(pageNumber,pageSize));
//    }







}
