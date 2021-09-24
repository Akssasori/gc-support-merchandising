package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ProgramRequestDto;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.models.Program;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface ProgramMapper {

    /**
     * Instance of StationMapper class.
     */
    ProgramMapper INSTANCE = Mappers.getMapper(ProgramMapper.class);


    Program programRequestDtoToProgram(ProgramRequestDto programRequestDto);


    ProgramResponseDto programToProgramResponseDTO(Program program);

    /**
     * Mapper findAll with page convert programList to ProgramResponseDtoList
     */
    List<ProgramResponseDto> programListToProgramResponseDtoList(List<Program> programs);

    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * inside it is used the mapper programListToProgramResponseDtoList
     *
     * @param pageRequest The information of the requested page.
     * @param programPage The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    default Page<ProgramResponseDto> mapEntityPageIntoDTOPage(
            Pageable pageRequest, Page<Program> programPage) {

        if (programPage == null) {
            return null;
        }
        List<ProgramResponseDto> programResponseDtoList =
                INSTANCE.programListToProgramResponseDtoList(
                        programPage.getContent());

        return new PageImpl<>(programResponseDtoList,
                pageRequest, programPage.getTotalElements());

    }

    //    /**
//     *Mapper Page findAll
//     */
//    Page<ProgramResponseDto> programPageToProgramResponseDtoPage(Page<Program>programsPage);

}
