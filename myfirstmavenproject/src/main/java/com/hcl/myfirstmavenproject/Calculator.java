package com.hcl.Calculator1;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		execute();
	}

	private static void execute() {
		Scanner scanner = new Scanner(System.in);

		BinaryOperation binaryOperation = getInputs(scanner);
		switch (binaryOperation.operation) {
		case '+':
			add(binaryOperation.num1, binaryOperation.num2);
			break;
		case '-':
			subtract(binaryOperation.num1, binaryOperation.num2);
			break;
		case '*':
			multiply(binaryOperation.num1, binaryOperation.num2);
			break;
		case '/':
			divide(binaryOperation.num1, binaryOperation.num2);
			break;
		default:
			invaldOperator();
		}
	}

	private static BinaryOperation getInputs(Scanner scanner) {
		System.out.print("Enter first number: ");
		double num1 = scanner.nextDouble();

		System.out.print("Enter second number: ");
		double num2 = scanner.nextDouble();

		System.out.print("Select operator (+ - * /): ");
		char operator = scanner.next().charAt(0);

		BinaryOperation binaryOperation = new BinaryOperation();
		binaryOperation.operation = operator;
		binaryOperation.num1 = num1;
		binaryOperation.num2 = num2;
		return binaryOperation;
	}

	private static void invaldOperator() {
		System.out.println("Wrong operator, try again.");
	}

	private static void divide(double num1, double num2) {
		double answer = num1 / num2;
		System.out.println(answer);
	}

	private static void multiply(double num1, double num2) {
		double answer = num1 * num2;
		System.out.println(answer);
	}

	private static void subtract(double num1, double num2) {
		double answer = num1 - num2;
		System.out.println(answer);
	}

	private static void add(double num1, double num2) {
		double answer = num1 + num2;
		System.out.println(answer);
	}
}

class BinaryOperation {
	char operation;
	double num1;
	double num2;
}