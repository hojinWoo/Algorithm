import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] RGB = new int[T+1][4];
        //dp[n][k] : n번째 줄의 k집을 선택한 경우, 최소 비용
		int[][] dp = new int[T+1][4];
		//R : 1, G : 2, B : 3
		for(int i=1;i<=T;i++){
			for(int j=1;j<=3;j++){
				RGB[i][j] = sc.nextInt();
			}
		}
		for(int n=1;n<=T;n++){
			for(int k=1;k<=3;k++){
				//ex) k==1 >전 단계에 sum을 한 2와 3중 작은 값 + 현 단계 값
				dp[n][k] = Math.min(dp[n-1][k%3+1],dp[n-1][(k+1)%3+1])+RGB[n][k];
			}
		}
		//3개여서 그냥 있는 것 활용. for문으로 최소값 찾거나 따로 function을 만들어서 할 수도 있음
		int sum = Math.min(Math.min(dp[T][1], dp[T][2]),dp[T][3]);
		System.out.println(sum);
	}
}
