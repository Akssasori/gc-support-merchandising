package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.models.Program;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramMapper {

    ProgramMapper INSTANCE = Mappers.getMapper(ProgramMapper.class);


    Program programRequestDtoToProgram(ProgramRequestDto programRequestDto);

    ProgramResponseDto programToProgramResponseDTO(Program program);

    List<ProgramResponseDto> programListToProgramResponseDtoList(List<Program> programs);


}
