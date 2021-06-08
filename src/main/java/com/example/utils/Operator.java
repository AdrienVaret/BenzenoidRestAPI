package com.example.utils;

public enum Operator {
	LEQ, LT, EQ, GT, GEQ, DIFF;

	public static String getOperatorString(Operator operator) {

		switch (operator) {

		case LEQ:
			return "<=";

		case LT:
			return "<";

		case EQ:
			return "=";

		case GT:
			return ">";

		case GEQ:
			return ">=";

		case DIFF:
			return "<>";

		default:
			return null;
		}
	}

	public static Operator getOperator(String operatorString) {

		if (operatorString.equals("<=") || operatorString.equals("leq"))
			return Operator.LEQ;

		else if (operatorString.equals("<") || operatorString.equals("lt"))
			return Operator.LT;

		else if (operatorString.equals("=") || operatorString.equals("eq"))
			return Operator.EQ;

		else if (operatorString.equals(">") || operatorString.equals("gt"))
			return Operator.GT;

		else if (operatorString.equals(">=") || operatorString.equals("geq"))
			return Operator.GEQ;

		else if (operatorString.equals("<>") || operatorString.equals("dif"))
			return Operator.DIFF;

		else
			return null;

	}
}
