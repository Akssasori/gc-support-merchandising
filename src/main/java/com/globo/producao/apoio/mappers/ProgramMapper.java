package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.models.Program;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramMapper {

    Program programRequestDtoToProgram(ProgramRequestDto programRequestDto);

    ProgramResponseDto programToProgramResponseDTO(Program program);

    List<ProgramResponseDto> programListToProgramResponseDtoList(List<Program> programs);

    default Page<ProgramResponseDto> programToProgramResponseDTOPage(Page<Program> programs){
        return programs.map(this::programToProgramResponseDTO);
    }

}
