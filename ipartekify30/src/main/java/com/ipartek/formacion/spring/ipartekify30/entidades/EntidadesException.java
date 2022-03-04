package com.ipartek.formacion.spring.ipartekify30.entidades;

// @StandardException
public class EntidadesException extends RuntimeException {

	public EntidadesException() {
		super();
	}

	public EntidadesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntidadesException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadesException(String message) {
		super(message);
	}

	public EntidadesException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 5804973342838400993L;

}
