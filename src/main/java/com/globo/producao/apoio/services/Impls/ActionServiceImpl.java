package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Action;
import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.repositories.ActionRepository;
import com.globo.producao.apoio.services.interfaces.ActionService;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.NoEntityException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository repository;
    private final AgencyServiceImpl agencyService;
    private final ClientServiceImpl clientService;


    @Override
    @Transactional
    public Action save(Action action) throws Exception {

        Duration(action);
        action.setAgency(agencyService.save(action.getAgency()));
        action.setClient(clientService.save(action.getClient()));
        Action actionSave = repository.save(action);

        return actionSave;
    }

    @Override
    public List<Action> findAll() {
        return repository.findAll();
    }

    @Override
    public Action findById(Long ActionId) {
        return repository.findById(ActionId).orElseThrow(() -> new NoEntityException(ActionId.toString()));
    }

    @Override
    @SneakyThrows
    public Action update(Long actionId, Action action) {

        Action actionDB = repository.findById(actionId).orElseThrow(() -> new NoEntityException(actionId.toString()));

        try {
            actionDB.setId(actionId);
            actionDB.setTypeAction(action.getTypeAction());
            actionDB.setDescription(action.getDescription());
            actionDB.setReviewDate(action.getReviewDate());
            actionDB.setStartTime(action.getStartTime());
            actionDB.setEndTime(action.getEndTime());
            actionDB.setDuration(Duration(action));
            actionDB.setProgram(action.getProgram());
            actionDB.setAgency(action.getAgency());
            actionDB.setClient(action.getClient());
            actionDB.setProduct(action.getProduct());
            actionDB.setPayTVFlag(action.getPayTVFlag());
            return repository.save(actionDB);
        } catch (Exception e) {
            throw new FindDataException(e.getMessage());
        }

    }

    @Override
    @SneakyThrows
    public void delete(Long actionId) {

        try {
            if (repository.existsById(actionId)) {
                repository.deleteById(actionId);
            } else {
                ResponseEntity.notFound();
            }
        } catch (Exception e) {
            throw new DeleteDataException(e.getMessage());
        }

    }

    @Override
    public Page<Action> pageAction(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    private Duration Duration(final Action action){

        Duration duration = Duration.between(action.getStartTime(), action.getEndTime());
//        String formattedTime = String.format("%02d:%02d:%02d", duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());
//        System.out.println("aaaaaaaaaaaaaaaaaa" + formattedTime);
        action.setDuration(duration);

        return duration;
    }



}
