package linear_algebra.system_equations;

import java.util.ArrayList;
import java.util.List;

import linear_algebra.Util;
import linear_algebra.exceptions.DiffernetDimentionsVectorException;
import linear_algebra.vector.Vector;
import lombok.Getter;
import lombok.Setter;

/**
 * @author supermario
 *
 */
public class LinearSystem {
	int params;
	List<Equation> equations;
	int maxdigit = 2;

	/**
	 * @param params
	 *            is the number of params x1, x2, x3....xn (x,y,z...n) for the
	 *            function in the system of equationsO
	 */
	public LinearSystem(int params) {
		this.params = params;
		equations = new ArrayList<Equation>();
	}

	public void addEquation(Equation equation) throws DiffernetDimentionsVectorException {
		if (equation.getNormal_vector().getCoordinates().length < params) {
			throw new DiffernetDimentionsVectorException();
		}

		// for (Double xn : equation.getNormal_vector().getCoordinates()) {
		// if (Util.numberOfDigits(xn) > maxdigit) {
		// maxdigit = Util.numberOfDigits(xn);
		// }
		// }
		// if (Util.numberOfDigits(equation.getConstant()) > maxdigit) {
		// maxdigit = Util.numberOfDigits(equation.getConstant());
		// }

		equations.add(equation);

		readjustDecimalPlacesAndMaxigitForRow(equations.indexOf(equation) + 1);
	}

	public void swapRows(int row1, int row2) {
		row1--;
		row2--;
		Equation eq1 = equations.get(row1);
		Equation eq2 = equations.get(row2);
		equations.set(row1, eq2);
		equations.set(row2, eq1);
	}

	public void multiplyRowPermanent(int row1, double coeaficient) {

		equations.set(row1, getMultipliedRow(row1, coeaficient));
		readjustDecimalPlacesAndMaxigitForRow(row1);
	}

	public Equation getMultipliedRow(int row1, double coeficient) {
		row1--;

		Equation oldEquation = equations.get(row1);
		Equation equation = new Equation(new Vector(oldEquation.getNormal_vector().getCoordinates().length), oldEquation.getConstant());

		for (int i = 0; i < equation.getNormal_vector().getCoordinates().length; i++) {
			equation.getNormal_vector().getCoordinates()[i] = oldEquation.getNormal_vector().getCoordinates()[i]
					* coeficient;
		}
		equation.setConstant(equation.getConstant() * coeficient);
		return equation;
	}

	public void addMultipliedRowToRow(int rowMultiplied, double coeficient, int rowToAddTo) {

		Equation equationMultiplied =  this.getMultipliedRow(rowMultiplied, coeficient);

//		System.out.println("MULT: " + equationMultiplied);

		addEquationtoRow(equationMultiplied, rowToAddTo);
		
		readjustDecimalPlacesAndMaxigitForRow(rowToAddTo);

	}

	private void addEquationtoRow(Equation eq, int rowToAddTo) {
		rowToAddTo--;

		Equation equationToAddTo = equations.get(rowToAddTo);

		for (int i = 0; i < equationToAddTo.getNormal_vector().getCoordinates().length; i++) {
			equationToAddTo.getNormal_vector()
					.getCoordinates()[i] = equationToAddTo.getNormal_vector().getCoordinates()[i]
							+ eq.getNormal_vector().getCoordinates()[i];
		}

	//	System.out.println(equationToAddTo.getConstant() + " + " + eq.getConstant());

		equationToAddTo.setConstant(equationToAddTo.getConstant() + eq.getConstant());

	}

	private void readjustDecimalPlacesAndMaxigitForRow(int row) {

		row--;

		Equation eq = equations.get(row);

		for (int i = 0; i < eq.getNormal_vector().getCoordinates().length; i++) {

		//	System.out.println("MULT: " + eq.getNormal_vector().getCoordinates()[i]);
			
			
			eq.getNormal_vector().getCoordinates()[i] = Util.round(eq.getNormal_vector().getCoordinates()[i], 3);
			if (Util.numberOfDigits(eq.getNormal_vector().getCoordinates()[i]) > maxdigit) {
				maxdigit = Util.numberOfDigits(eq.getNormal_vector().getCoordinates()[i]);
			}
		}
		eq.setConstant(Util.round(eq.getConstant(), 3));
		if (Util.numberOfDigits(eq.getConstant()) > maxdigit) {
			maxdigit = Util.numberOfDigits(eq.getConstant());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append("\n");
		for (Equation eq : equations) {
			sb.append(eq.toString(maxdigit)).append("\n");
		}
		sb.append("}").append("\n");
		return sb.toString();
	}

	public static class Equation {
		@Getter
		@Setter
		private Vector normal_vector;
		@Getter
		@Setter
		private double constant;

		public Equation(Vector normal_vector, Double constant) {
			this.normal_vector = normal_vector;
			this.constant = constant;

			if (normal_vector == null) {
				this.normal_vector = new Vector(new Double[] { 0.0, 0.0, 0.0 });
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			int i = 1;
			for (double c : normal_vector.getCoordinates()) {
				if (c >= 0) {
					sb.append("+" + c + " x" + i + " ");
				} else {
					sb.append(+c + " x" + i + " ");
				}
				i++;
			}
			sb.append("= ").append(constant);
			return sb.toString();
		}

		public String toString(int maxDigitAlign) {
			StringBuilder sb = new StringBuilder();
			int i = 1;
			for (double c : normal_vector.getCoordinates()) {

				if (c >= 0) {
					sb.append("+");
					for (int s = Util.numberOfDigits(c); s < maxDigitAlign; s++) {
						sb.append(" ");
					}
					sb.append(c + " x" + i + " ");
				} else {
					for (int s = Util.numberOfDigits(c); s < maxDigitAlign; s++) {
						sb.append(" ");
					}
					sb.append(+c + " x" + i + " ");
				}
				i++;
			}
			sb.append("= ");
			for (int k = Util.numberOfDigitsSign(constant); k < maxDigitAlign; k++) {
				sb.append(" ");
			}
			sb.append(constant);
			return sb.toString();
		}
	}

}
