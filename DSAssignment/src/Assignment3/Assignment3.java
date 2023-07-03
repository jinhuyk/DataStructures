package Assignment3;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackQueue queue = new StackQueue(50);
		// 1) 'a' ~ 'e' enqueue
		for(char i = 97;i<102;i++) {
			queue.enqueue(i);
		}
		// 2) dequeue
		for(int i = 0;i<3;i++) {
			System.out.print(queue.dequeue());
		}
		// 3) 'f' ~ 'j' enqueue
		System.out.println();
		for(char i = 102;i<107;i++) {
			queue.enqueue(i);
		}
		// 4) dequeue
		for(int i = 0;i<3;i++) {
			System.out.print(queue.dequeue());
		}
		// 5) 'k' ~ 'o' enqueue
		System.out.println();
		for(char i = 107;i<112;i++) {
			queue.enqueue(i);
		}
		// 5) dequeue
		for(int i = 0;i<6;i++) {
			System.out.print(queue.dequeue());
		}
		System.out.println();
		// 7) dequeue
		while(!queue.isEmpty()) {
			System.out.print(queue.dequeue());
		}


	}
}
