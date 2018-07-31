import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(min_value(num));
	}
	static int min_value(int n){
    if(n%5==0) return n/5;
		else{
			for(int i=1;i<5;i++){
				while(((n-(3*i))%5==0)&&(n-(3*i))>=0){
					return (n-(3*i))/5 + i;
				}
			}
		}
		return -1;
	}
}
