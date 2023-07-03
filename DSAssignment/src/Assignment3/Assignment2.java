package Assignment3;

import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S;
		ArrayStack stack = new ArrayStack(50);
		Scanner scan = new Scanner(System.in);
		S = scan.nextLine();
		char[] arrS = S.toCharArray();

		for( char i : arrS) {
			if(i == '(') {
				stack.push(')');
			}
			else if(i == ')') {
				stack.push('(');
			}
			else {
				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}


	}

}
