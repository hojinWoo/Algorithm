import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue q = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int last = -1;
		int temp = sc.nextInt();
		for (int i = 0; i < temp; i++) {
			String input = sc.next();
			if (input.equals("push")) {
				last = sc.nextInt();
				q.offer(last); // not push
			} else if (input.equals("pop")) {
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll()); // extract and pop
			} else if (input.equals("size")) {
				System.out.println(q.size());
			} else if (input.equals("empty")) {
				if (q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (input.equals("front")) {
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
			} else if(input.equals("back")){
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(last); //there is no peekLast method
			}
		}
	}
}
