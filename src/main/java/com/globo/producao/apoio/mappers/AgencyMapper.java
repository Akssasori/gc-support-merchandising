package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.AgencyRequestDTO;
import com.globo.producao.apoio.dtos.requests.ProductRequestDTO;
import com.globo.producao.apoio.dtos.response.AgencyResponseDTO;
import com.globo.producao.apoio.dtos.response.ProductResponseDTO;
import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.models.Product;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AgencyMapper {

    Agency agencyRequestDTOToAgency(AgencyRequestDTO agencyRequestDTO);

    AgencyResponseDTO agencyToAgencyResponseDTO(Agency agency);

    List<AgencyResponseDTO> agencyListToAgencyResponseDTO(Set<Agency> agencies );


}
