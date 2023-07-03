package Assignment3;

import java.util.EmptyStackException;


// Assignment 1
public class ArrayStack implements Stack{

	private char[] S;
	private int t;
	private int N;
	
	public ArrayStack(int N) {
		S = new char[N];
		t = -1;
		this.N = N;
	}
	@Override
	public int size() {
		return t+1;
	}

	@Override
	public boolean isEmpty() {
		return t < 0;
	}

	@Override
	public char top() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else return S[t];
	}

	@Override
	public char push(char o) {
		if(t == N-1) {
			throw new FullStackException();
		}
		else {
			t = t+1;
			S[t] = o;
		}
		return o;	
	}

	@Override
	public char pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			char o = S[t];
			t = t-1;
			return o;
		}
	}

}
