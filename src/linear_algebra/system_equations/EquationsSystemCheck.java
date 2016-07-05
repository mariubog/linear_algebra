package linear_algebra.system_equations;

import linear_algebra.system_equations.LinearSystem.Equation;
import linear_algebra.vector.Vector;

public class EquationsSystemCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Equation l1 = new Equation(new Vector(new Double[] { -0.412, 3.806, 0.728 }), -3.46);
		Equation l2 = new Equation(new Vector(new Double[] { 1.03, -9.515, -1.82 }), 8.65);

		Equation l3 = new Equation(new Vector(new Double[] { 2.611, 5.528, 0.283 }), 4.6);
		Equation l4 = new Equation(new Vector(new Double[] { 7.715, 8.306, 5.342 }), 3.76);

		LinearSystem ls = new LinearSystem(3);

		ls.addEquation(l1);
		ls.addEquation(l2);
		ls.addEquation(l3);
		ls.addEquation(l4);
		System.out.println(ls.toString());
		// ls.swapRows(1, 3);
	//	 ls.addMultipliedRowToRow(1, 2, 2);
	  	 ls.addMultipliedRowToRow(1, 4, 2);
		System.out.println(ls.toString());
	}

}
