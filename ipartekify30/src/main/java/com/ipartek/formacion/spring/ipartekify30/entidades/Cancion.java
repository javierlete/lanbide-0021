package com.ipartek.formacion.spring.ipartekify30.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "canciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cancion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String tiempo;
	private String mp3;
	private Boolean favorito;

	@JsonBackReference
	@ManyToOne
	private Album album;
}
