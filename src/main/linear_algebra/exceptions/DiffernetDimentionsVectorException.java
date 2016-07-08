package main.linear_algebra.exceptions;

public class DiffernetDimentionsVectorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DiffernetDimentionsVectorException() {
		super("Vectors are of different dimensions");
	}

	public DiffernetDimentionsVectorException(String message) {
		super(message);
	}

}