package com.servidor.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_autor;
	
	@NotNull(message = "El campo nombre del autor es obligatorio")
	private String nombre_autor;
	
	
	@NotNull(message = "El campo apellido del autor es obligatorio")
	private String apellido_autor;
	
	
	@NotNull(message = "El campo fecha de nacimiento del autor es obligatorio")
	private Date fechanacimiento_autor;
}
