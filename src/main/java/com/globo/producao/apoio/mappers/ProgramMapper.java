package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDTO;
import com.globo.producao.apoio.dtos.response.ProgramResponseDTO;
import com.globo.producao.apoio.models.Program;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramMapper {

    Program programRequestDtoToProgram(ProgramRequestDTO programRequestDto);

    ProgramResponseDTO programToProgramResponseDTO(Program program);

    List<ProgramResponseDTO> programListToProgramResponseDtoList(List<Program> programs);

    default Page<ProgramResponseDTO> programToProgramResponseDTOPage(Page<Program> programs){
        return programs.map(this::programToProgramResponseDTO);
    }

}
