package main.linear_algebra.exceptions;

public class ImpossileVectorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImpossileVectorException() {
		super("Wrong coordinates exception");
	}

	public ImpossileVectorException(String message) {
		super(message);
	}
}
