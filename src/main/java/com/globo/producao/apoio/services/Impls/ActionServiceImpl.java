package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Action;
import com.globo.producao.apoio.repositories.ActionRepository;
import com.globo.producao.apoio.services.interfaces.ActionService;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.exceptions.NoEntityException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository repository;
    private final AgencyServiceImpl agencyService;
    private final ClientServiceImpl clientService;
    private final ProductServiceImpl productService;
    private final ProgramServiceImpl programService;


    @Override
    @SneakyThrows
    @Transactional
    public Action save(Action action) {

        if (Objects.nonNull(action)) {

            Duration(action);
            action.setProgram(programService.save(action.getProgram()));
            action.setProduct(productService.save(action.getProduct()));
            action.setAgency(agencyService.save(action.getAgency()));
            action.setClient(clientService.save(action.getClient()));
            action.setReviewTime(LocalDateTime.now());
            action.setStartTime(action.getStartTime());
            action.setEndTime(action.getEndTime());
            return repository.save(action);

        } else {

            throw new InsertDataException(action.toString());
        }
    }

    @Override
    public List<Action> findAllAction() {
        return repository.findAllAction();
    }

    @Override
    public Action findById(Long ActionId) {
        return repository.findById(ActionId).orElseThrow(() -> new NoEntityException(ActionId.toString()));
    }

    @Override
    @SneakyThrows
    public Action update(Long actionId, Action action) {

        var actionDB = repository.findById(actionId)
                .orElseThrow(() -> new NoEntityException(actionId.toString()));

        try {
            actionDB.setId(actionId);
            actionDB.setTypeAction(action.getTypeAction());
            actionDB.setDescription(action.getDescription());
            actionDB.setUpdateTime(action.getUpdateTime());
            actionDB.setStartTime(action.getStartTime());
            actionDB.setEndTime(action.getEndTime());
            actionDB.setDuration(Duration(action));
            actionDB.setProgram(action.getProgram());
            actionDB.setAgency(action.getAgency());
            actionDB.setClient(action.getClient());
            actionDB.setProduct(action.getProduct());
            actionDB.setPayTVFlag(action.getPayTVFlag());
            actionDB.setUpdateTime(LocalDateTime.now());
            return repository.save(actionDB);
        } catch (Exception e) {
            throw new FindDataException(e.getMessage());
        }

    }

    @Override
    @SneakyThrows
    public void delete(Long actionId) {


        if (repository.existsById(actionId)) {
            repository.deleteById(actionId);
        } else {
            throw new NoEntityException(actionId.toString());
        }


    }

    @Override
    public Page<Action> pageAction(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    private Duration Duration(final Action action) {

        if (action.getStartTime().isBefore(action.getEndTime()) ||
                action.getStartTime().isEqual(action.getEndTime()) ) {

            Duration duration = Duration.between(action.getStartTime(), action.getEndTime());
            action.setDuration(duration);
            String hms = String.format("%d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
            System.out.println(hms);
            return duration;

        }

        return null;

    }


}
