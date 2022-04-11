package com.hcl.Calculator1;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		execute();
	}

	private static void execute() {
		Scanner scanner = new Scanner(System.in);

		binaryOp binaryOp = getInputs(scanner);
		switch (binaryOp.operation) {
		case '+':
			add(binaryOp.a, binaryOp.a);
			break;
		case '-':
			subtract(binaryOp.a, binaryOp.b);
			break;
		case '*':
			multiply(binaryOp.a, binaryOp.b);
			break;
		case '/':
			divide(binaryOp.a, binaryOp.b);
			break;
		default:
			invaldOperator();
		}
	}

	private static binaryOp getInputs(Scanner scanner) {
		System.out.print("Enter first number: ");
		double a = scanner.nextDouble();

		System.out.print("Enter second number: ");
		double b = scanner.nextDouble();

		System.out.print("Select operator (+ - * /): ");
		char operator = scanner.next().charAt(0);

		binaryOp binaryOp = new binaryOp();
		binaryOp.operation = operator;
		binaryOp.a = a;
		binaryOp.b = b;
		return binaryOp;
	}

	private static void invaldOperator() {
		System.out.println("Wrong operator, try again.");
	}

	private static void divide(double a, double b) {
		double answer = a / b;
		System.out.println(answer);
	}

	private static void multiply(double a, double b) {
		double answer = a * b;
		System.out.println(answer);
	}

	private static void subtract(double a, double b) {
		double answer = a - b;
		System.out.println(answer);
	}

	private static void add(double a, double b) {
		double answer = a + b;
		System.out.println(answer);
	}
}

class binaryOp {
	char operation;
	double a;
	double b;
}