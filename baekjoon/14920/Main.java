import java.util.Scanner;

//Collatz Conjecture
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		System.out.println(calcul(T));

	}
	public static int calcul(int n){
		if(n==1){
			return 1;
		}
		else if (n%2==0){
			return calcul(n/2)+1;
		}
		else {
			return calcul(3*n+1)+1;
		}
	}
}
