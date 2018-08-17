import java.util.Scanner;

class Stack{
	int top;
	int size;
	int[] stack;

	public Stack(int size){
		this.size = size;
		this.stack = new int[size];
		this.top=-1;
	}

	void push(int X){
		stack[++top] = X;
	}
	void pop(){
		if(top==-1) {
			System.out.println(-1);
		}
		else{
			System.out.println(stack[top--]);
		}
	}
	void size(){
		System.out.println(top+1);
	}
	void empty(){
		if(top==-1) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	void top(){
		if (top==-1) {
			System.out.println(-1);
		}
		else {
			System.out.println(stack[top]);
		}
	}
}

public class Main {
	//static ArrayList<Integer> al = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st = new Stack(10000);
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		for(int i=0;i<temp;i++){
			String input = sc.next();
			if(input.equals("push")){
				int a = sc.nextInt();
				st.push(a);
			}
			else if(input.equals("pop")){
				st.pop();
			}
			else if(input.equals("size")){
				st.size();
			}
			else if(input.equals("empty")){
				st.empty();
			}
			else{
				st.top();
			}
		}
	}
}
