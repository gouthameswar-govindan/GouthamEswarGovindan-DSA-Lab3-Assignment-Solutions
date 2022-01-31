package com.dsa_lab_3;
//Java Program To Check String is Balanced or Not With The Help Of Balancing Brackets:
import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {

	private static Scanner sc;

	public static void main(String[] args) {

		System.out.println("Enter The String of Brackets That Needs To Be Checked:");
		sc = new Scanner(System.in);
		/*
		 * String brackets = "( [ [ { } ] ] ) )"; // Default - Inbuilt Input
		 */

		String input = sc.nextLine();
		String brackets = input.replaceAll(" ", "");
		// Getting Brackets String From The User //Replacing All White Spaces
		boolean result = areBracketsBalanced(brackets);

		if (result) {
			System.out.println("The Entered String Has Balanced Brackets -> (BALANCED STRING)");
		} else {
			System.out.println("The Entered String Do Not Contain Balanced Brackets -> (UNBALANCED STRING)");
		}
	}

	private static boolean areBracketsBalanced(String input) {
		// Function To Check Whether Given Brackets Are Balanced Or Not
		Stack<Character> stack = new Stack<Character>();
		// Stack Creation
		char[] inputArray = input.toCharArray();

		for (int i = 0; i < inputArray.length; i++) {
			// Expression Traversing
			if (inputArray[i] == '(' || inputArray[i] == '[' || inputArray[i] == '{') {
				stack.push(inputArray[i]);
				// Push The Element In The Stack
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char check;

			switch (inputArray[i]) {

			case ')':
				check = stack.pop();
				if (check == '[' || check == '{') {
					return false;
				}
				break;
			case ']':
				check = stack.pop();
				if (check == '(' || check == '{') {
					return false;
				}
				break;
			case '}':
				check = stack.pop();
				if (check == '[' || check == '(') {
					return false;
				}
				break;
			}
		}

		if (stack.isEmpty()) {
			// To Check Empty Stack
			return true;
		} else {
			return false;
		}
	}
}
