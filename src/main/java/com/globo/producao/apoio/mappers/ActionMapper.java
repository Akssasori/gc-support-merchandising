package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ActionRequestDTO;
import com.globo.producao.apoio.dtos.response.ActionResponseDTO;
import com.globo.producao.apoio.models.Action;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    Action actionRequestDtoToAction(ActionRequestDTO actionRequestDTO);

    ActionResponseDTO actionToActionResponseDTO(Action action);

    List<ActionResponseDTO> actionListToActionResponseDTOList(List<Action> actions);

    default Page<ActionResponseDTO> actionToActionResponseDTOPage(Page<Action> actions){
        return actions.map(this::actionToActionResponseDTO);
    }

}
