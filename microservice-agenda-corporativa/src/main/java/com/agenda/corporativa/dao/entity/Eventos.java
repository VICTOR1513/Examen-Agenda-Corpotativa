package com.agenda.corporativa.dao.entity;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
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

	@NotBlank
	private String nombre;

	@NotBlank
	@Column(name = "cupo")		
	private Integer cupo;

	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Integer fecha;



}
