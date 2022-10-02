package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.models.Action;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    @EntityGraph(attributePaths = {"typeAction", "duration", "client", "program",
            "product", "agency"})
    @Query("SELECT a FROM Action a")
    List<Action> findAllAction();

    @EntityGraph(attributePaths = {"typeAction", "duration", "client", "program",
            "product", "agency"})
    @Query("SELECT a FROM Action a")
    Page<Action> findAllActionPageable(Pageable pageable);

    @EntityGraph(attributePaths = {"typeAction", "duration", "client", "program",
            "product", "agency"})
    @Query("SELECT a FROM Action a WHERE a.id = :id")
    Optional<Action> findByIdAllData(Long id);


}
