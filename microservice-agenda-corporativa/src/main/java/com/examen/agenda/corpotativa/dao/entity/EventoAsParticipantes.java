package com.examen.agenda.corpotativa.dao.entity;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "evento_as_participantes")
@Data
public class EventoAsParticipantes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@JoinColumn(name = "id_participante", referencedColumnName = "id")
	@ManyToOne
	private Participantes idParticipante;

	@JoinColumn(name = "id_evento", referencedColumnName = "id")
	@ManyToOne
	private Eventos idEvento;

	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Integer fecha;

}
