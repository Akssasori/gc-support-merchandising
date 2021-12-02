package com.globo.producao.apoio.controllers;


import com.globo.producao.apoio.dtos.requests.ClientRequestDTO;
import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ClientResponseDTO;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.mappers.ClientMapper;
import com.globo.producao.apoio.mappers.ProgramMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ClientService;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.*;
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
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    private final ClientMapper mapper;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getClients() throws FindDataException {

        return status(HttpStatus.OK).body(mapper
                .clientListToClientResponseDTOList(service.findAll()));

    }

    @GetMapping(value = "/list-by/id")
    public ResponseEntity<ClientResponseDTO> getClientById
            (@RequestParam final Long id) throws FindDataException {

        return status(HttpStatus.OK).body(mapper
                .clientToClientResponseDTO(service.findById(id)));

    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ClientResponseDTO> createClient
            (@Valid @RequestBody final ClientRequestDTO clientRequestDTO) throws Exception {

        return status(HttpStatus.CREATED).body(mapper.clientToClientResponseDTO(
                service.save(mapper.clientRequestDTOToClient(clientRequestDTO))));
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<ClientResponseDTO> updateClientById (
            @PathVariable(value = "id") final Long id,
            @Valid @RequestBody final ClientRequestDTO clientRequestDTO) throws UpdateDataException {

        return status(HttpStatus.OK).body(mapper.clientToClientResponseDTO
                (service.update(id, mapper.clientRequestDTOToClient(clientRequestDTO))));

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Program> deleteClient (
            @PathVariable(value = "id") final Long id) throws DeleteDataException {

        service.delete(id);

        return ResponseEntity.ok().build();

    }

//    @GetMapping(value = "/page/{pageNumber}/{pageSize}")
//    public Page<ProgramResponseDto> pagePrograms(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
//
//        return mapper.programToProgramResponseDTOPage(programService.pageProgram(pageNumber,pageSize));
//    }







}
