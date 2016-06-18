/**
 * 
 */
package linear_algebra;

import java.util.Arrays;

/**
 * @author supermario
 *
 */
public class Vector {
	private double[] coordinates;

	public Vector(double[] coordinates) throws ImpossileVectorException {
		if (coordinates == null || coordinates.length < 1) {
			throw new ImpossileVectorException();
		}
		this.coordinates = coordinates;
	}

	public Vector(int coordinatesNumber) {
		this.coordinates = new double[coordinatesNumber];
	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

	public int compareDimention(Vector v) {
		if (this.getCoordinates().length > v.getCoordinates().length) {
			return 1;
		} else if (this.getCoordinates().length < v.getCoordinates().length) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Vector) {
			Vector v = (Vector) o;
			if (v.getCoordinates().length != this.coordinates.length) {
				throw new DiffernetDimentionsVectorException();
			}
			return Arrays.equals(v.getCoordinates(), coordinates);
		}
		return false;
	}

	@Override
	public String toString() {
		return Arrays.toString(coordinates);
	}

	public static class ImpossileVectorException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ImpossileVectorException() {
			super("Wrong coordinates exception");
		}

		public ImpossileVectorException(String message) {
			super(message);
		}
	}

	public static class DiffernetDimentionsVectorException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public DiffernetDimentionsVectorException() {
			super("Vectors are of different dimensions");
		}

		public DiffernetDimentionsVectorException(String message) {
			super(message);
		}

	}
}
