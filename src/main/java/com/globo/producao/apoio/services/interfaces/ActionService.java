package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Action;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActionService {

    Action save(Action action);

    List<Action>findAllAction();

    Action findById(Long ActionId);

    Action update(Long actionId, Action action);

    void delete(Long actionId);

    Page<Action> pageAction(Integer pageNumber, Integer pageSize);


}
