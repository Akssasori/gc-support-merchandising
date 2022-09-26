package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.models.Action;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    @EntityGraph(attributePaths = {"typeAction", "duration", "client", "program",
    "product", "agency"})
    @Query("SELECT a FROM Action a")
    List<Action> findAllAction();


}
