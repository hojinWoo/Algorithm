import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] arr = new int[cnt+1];
		for (int i=1;i<=cnt;i++){
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[cnt+1];
		//init
		dp[1] = arr[1];
		int max_value=arr[1];
		//신경 쓸것 : 음수만 있을 때. 0이 들어갈 때.
		//ex 5
		//-1 34 -2 5 6인 경우
		//DP로 풀어야만 하는 이유, 만일 음수 나왔다고 0으로 만들어버리면 안 되기 때문
		for(int i=2;i<=cnt;i++){
			if(dp[i-1]>0 && dp[i-1]+arr[i]>=0){
				dp[i] =dp[i-1]+arr[i];
				if(max_value<dp[i]){
					max_value=dp[i];
				}
			}
			else{
				dp[i]=arr[i];
				if(max_value<dp[i]){
					max_value=dp[i];
				}
			}
		}
		System.out.println(max_value);
	}
}
