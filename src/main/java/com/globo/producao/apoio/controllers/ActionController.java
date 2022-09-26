package com.globo.producao.apoio.controllers;


import com.globo.producao.apoio.dtos.requests.ActionRequestDTO;
import com.globo.producao.apoio.dtos.response.ActionResponseDTO;
import com.globo.producao.apoio.mappers.ActionMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("action")
@RequiredArgsConstructor
public class ActionController {

    private final ActionService service;

    private final ActionMapper mapper;

    @GetMapping
    public ResponseEntity<List<ActionResponseDTO>> getActions() {

        return status(HttpStatus.OK).body(mapper.actionListToActionResponseDTOList(new HashSet<>(service.findAllAction())));

    }

    @GetMapping("{id}")
    public ResponseEntity<ActionResponseDTO> getActionById
            (@PathVariable final Long id) {

        return status(HttpStatus.OK).body(mapper.actionToActionResponseDTO(service.findById(id)));

    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ActionResponseDTO> saveAction
            (@Valid @RequestBody final ActionRequestDTO actionRequestDTO) {

        return status(HttpStatus.CREATED).body(mapper.actionToActionResponseDTO(
                service.save(mapper.actionRequestDtoToAction(actionRequestDTO))));
    }

    @PutMapping("{id}")
    public ResponseEntity<ActionResponseDTO> updateActionById (
            @PathVariable(value = "id") final Long id,
            @Valid @RequestBody final ActionRequestDTO actionRequestDTO) {

        return status(HttpStatus.OK).body(mapper.actionToActionResponseDTO
                (service.update(id, mapper.actionRequestDtoToAction(actionRequestDTO))));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Program> actionProgram (
            @PathVariable(value = "id") final Long actionId) {

        service.delete(actionId);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/page/{pageNumber}/{pageSize}")
    public Page<ActionResponseDTO> pageActions(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){

        return mapper.actionToActionResponseDTOPage(service.pageAction(pageNumber,pageSize));
    }







}
