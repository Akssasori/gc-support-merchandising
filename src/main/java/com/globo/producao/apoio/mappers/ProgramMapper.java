package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.models.Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProgramMapper {

    /**
     * Instance of StationMapper class.
     */
    ProgramMapper INSTANCE = Mappers.getMapper(ProgramMapper.class);
//
//    @Mappings({
//            @Mapping(target = "program", source = "programRequestDto.program")
//    })
    Program programRequestDtoToProgram(ProgramRequestDto programRequestDto);


    ProgramResponseDto programToProgramResponseDTO(Program program);

//    default ProgramResponseDto programToProgramResponseDTO(Program program) {
//        if (program == null) {
//            return null;
//        } else {
//            ProgramResponseDto.ProgramResponseDtoBuilder programResponseDto = ProgramResponseDto.builder();
//            programResponseDto.program(program.getProgram());
//            return programResponseDto.build();
//        }
//    }

    /**
     *Mapper findAll
     */
    List<ProgramResponseDto> programListToProgramResponseDtoList(List<Program>programs);

}
