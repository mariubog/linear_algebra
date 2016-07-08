/**
 * 
 */
package main.linear_algebra.vector;

import java.util.Arrays;

import main.linear_algebra.exceptions.*;

/**
 * @author supermario
 *
 */
public class Vector {
	private Double[] coordinates;

	public Vector(Double[] coordinates) throws ImpossileVectorException {
		if (coordinates == null || coordinates.length < 1) {
			throw new ImpossileVectorException();
		}
		this.coordinates = coordinates;
	}

	public Vector(int coordinatesNumber) {
		this.coordinates = new Double[coordinatesNumber];
	}

	public Double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Double[] coordinates) {
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

}
