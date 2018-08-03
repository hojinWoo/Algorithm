import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int temp = sc.nextInt();
		int[] stairs = new int[temp+1];
		//input
		for(int i=1;i<=temp;i++){
			stairs[i] = sc.nextInt();
		}
		int[] dp = new int[temp+1];
		//initialize
		dp[1] = stairs[1];
		//한번에 두칸 or 한칸씩
		dp[2] = Math.max(stairs[1]+stairs[2],stairs[2]);
		//dp[3] = Math.max(stairs[1]+stairs[3],stairs[2]+stairs[3]);

		for(int n=3;n<=temp;n++){
			//마지막 계단을 기준 생각한다면 마지막 전은 무조건 밟아야 하기 때문
			dp[n]=Math.max(dp[n-2]+stairs[n], stairs[n-1]+stairs[n]+dp[n-3]);
		}
		System.out.println(dp[temp]);
	}
}
