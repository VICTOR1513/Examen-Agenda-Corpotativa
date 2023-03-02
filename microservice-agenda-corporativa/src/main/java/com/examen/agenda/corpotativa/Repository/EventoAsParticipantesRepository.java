package com.examen.agenda.corpotativa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examen.agenda.corpotativa.entity.EventoAsParticipantes;

@Repository
public interface EventoAsParticipantesRepository extends JpaRepository<EventoAsParticipantes, Integer> {

	@Query("SELECT E FROM EventoAsParticipantes E WHERE E.idEvento.id = ?1")
	List<EventoAsParticipantes> findEventoAsParticipantesByIdEvento(Integer id);

}
