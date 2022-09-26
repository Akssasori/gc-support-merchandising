package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ClientRequestDTO;
import com.globo.producao.apoio.dtos.response.ClientResponseDTO;
import com.globo.producao.apoio.models.Client;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client clientRequestDTOToClient(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO clientToClientResponseDTO(Client client);

    List<ClientResponseDTO> clientListToClientResponseDTOList(Set<Client> clients);

//    default Page<ProgramResponseDto> programToProgramResponseDTOPage(Page<Program> programs){
//        return programs.map(this::programToProgramResponseDTO);
//    }

}
