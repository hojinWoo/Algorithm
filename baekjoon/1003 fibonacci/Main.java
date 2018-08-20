import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int num = sc.nextInt();
			fibonacci(num);
		}
	}
	public static void fibonacci(int num){
		if(num == 0){
			System.out.println("1 0");
		}else if (num == 1){
			System.out.println("0 1");
		}else{
			//재귀나 dfs로 풀지 않고 for문으로 풀기.
			int arr[][] = new int[num+1][2];
			arr[0][0] = 1;
			arr[0][1] = 0;
			arr[1][0] = 0;
			arr[1][1] = 1;
			for(int i=2;i<=num;i++){
				for(int j=0;j<=1;j++){
					arr[i][j]=arr[i-1][j]+arr[i-2][j];
				}
			}
			System.out.println(arr[num][0]+" "+arr[num][1]);
		}
	}
}
