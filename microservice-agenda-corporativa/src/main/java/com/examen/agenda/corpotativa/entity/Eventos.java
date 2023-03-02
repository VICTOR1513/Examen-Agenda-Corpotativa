package com.examen.agenda.corpotativa.entity;

import java.io.Serializable;
import java.util.Date;

import com.examen.agenda.corpotativa.utils.Constantes;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "eventos")
@Data
public class Eventos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cupo")
	private Integer cupo;

	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;

	@Column(name = "fecha_modifico")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModifico;

}
