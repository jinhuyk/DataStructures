package Assignment3;

public class StackQueue implements Queue {
	
	private ArrayStack inStack;
	private ArrayStack outStack;
	
	public StackQueue(int N) {
		inStack = new ArrayStack(N);
		outStack = new ArrayStack(N);
	}
	@Override
	public int size() {
		return inStack.size() + outStack.size();
	}

	@Override
	public boolean isEmpty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}

	@Override
	public char front() {
		if (outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.top();
	}

	@Override
	public void enqueue(char o) {
		inStack.push(o);
	}

	@Override
	public char dequeue() {
		if (outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}


}
