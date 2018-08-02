import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();

		for(int temp=0;temp<T;temp++){
			int a = sc.nextInt();
			goldenbahh(a);
		}
	}
	static void goldenbahh(int n){
		int min=0;
		int max=10000;
		for(int i=2;i<=n/2;i++){
			if(prime(i)){
				if(prime(n-i)){
					if((n-(2*i))<max-min){
						min=i;
						max=n-i;
					}
				}
			}
		}
		System.out.println(min+" "+max);

	}
	static boolean prime(int n){
		if(n==1) return false;
		else if(n==2) return true;
		if(n%2==0 &&n>2) return false;
		for (int di = 3; di <= (int) Math.sqrt(n); di++) {
			if (n % di == 0) {
				return false;
			}
		}
		return true;
	}
}
