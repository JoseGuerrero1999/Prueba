package com.servidor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	
	@NotNull(message = "El campo razon social es obligatorio")
	private String razonsocial;
	
	@NotNull(message = "El campo RUC es obligatorio")
	@Pattern(regexp = "[0-9]{11}", message = "El RUC debe tener 11 digitos")
	private String ruc;
	
	@NotNull(message = "El campo direccion es obligatorio")
	private String direccion;
	
	@NotNull(message = "El campo celular es obligatorio")
	@Pattern(regexp = "[0-9]{9}", message = "El numero de celular debe tener 9 digitos")
	private String celular;
	
	@NotNull(message = "El campo contacto es obligatorio")
	private String contacto;
	
	@NotNull(message = "El campo estado es obligatorio")
	private int estado;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
	
	@NotNull(message = "El campo pais es obligatorio")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPais")
	private Pais pais;
}
