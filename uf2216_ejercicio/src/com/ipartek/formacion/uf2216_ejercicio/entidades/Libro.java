package com.ipartek.formacion.uf2216_ejercicio.entidades;

import java.util.Objects;

public class Libro {
	public static final Boolean FORMATO_PAPEL = false;
	public static final Boolean FORMATO_DIGITAL = true;

	private Long id;
	private String titulo;
	private String isbn;
	private Integer numeroPaginas;
	private Boolean formato;

	public Libro(Long id, String titulo, String isbn, Integer numeroPaginas, Boolean formato) {
		setId(id);
		setTitulo(titulo);
		setIsbn(isbn);
		setNumeroPaginas(numeroPaginas);
		setFormato(formato);
	}

	public Libro() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		titulo = titulo.trim();
		
		if (titulo == null || !(titulo.length() >= 3 && titulo.length() <= 150)) {
			throw new EntidadesException("El título debe tener entre 3 y 150 caracteres");
		}
		
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		isbn = isbn.trim();
		
		if(isbn == null || !isbn.matches("^\\d{10}$")) {
			throw new EntidadesException("El ISBN debe tener 10 dígitos");
		}
		
		this.isbn = isbn;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		if(numeroPaginas == null || numeroPaginas < 1) {
			throw new EntidadesException("El número de páginas debe ser al menos 1");
		}
		
		this.numeroPaginas = numeroPaginas;
	}

	public Boolean getFormato() {
		return formato;
	}

	public void setFormato(Boolean formato) {
		if(formato == null) {
			throw new EntidadesException("Se debe especificar el formato");
		}
		
		this.formato = formato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formato, id, isbn, numeroPaginas, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(formato, other.formato) && Objects.equals(id, other.id)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(numeroPaginas, other.numeroPaginas)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", numeroPaginas=" + numeroPaginas
				+ ", formato=" + formato + "]";
	}

}
