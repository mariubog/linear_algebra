package linear_algebra.exceptions;

public class InaplicableDimentionsVectorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InaplicableDimentionsVectorException() {
		super("Dimentions can't be applied");
	}

	public InaplicableDimentionsVectorException(String message) {
		super(message);
	}

}
