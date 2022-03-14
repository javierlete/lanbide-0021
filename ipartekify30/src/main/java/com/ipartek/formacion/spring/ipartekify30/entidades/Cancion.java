package com.ipartek.formacion.spring.ipartekify30.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "canciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cancion implements Serializable {
	private static final long serialVersionUID = 5884620573476254496L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=45)
	private String nombre;
	@NotNull
	@Size(max=8)
	@Column(columnDefinition="CHAR(8)")
	private String tiempo;
	@Size(max=45)
	private String mp3;

	@NotNull
	@JsonBackReference
	@ManyToOne
	private Album album;
}
