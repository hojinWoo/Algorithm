public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//buffer로 읽는 다면 더 시간이 반은 단축.. buffer연습 필요

		int temp = sc.nextInt();
		int[][] triangle = new int[temp+1][temp+1];
		//input
		for(int i=1;i<=temp;i++){
			for(int j=1;j<=i;j++){
				triangle[i][j] = sc.nextInt();
			}
		}
		//dp[n][k] : n행 k열 까지 오는 최대 합
		int[][] dp = new int[temp+1][temp+1];
		for(int n =1;n<=temp;n++){
			for (int k =1;k<=n;k++){
				//최대값
				dp[n][k] = Math.max(dp[n-1][k-1],dp[n-1][k])+triangle[n][k];
			}
		}
		int sum=0;
		//마지막 줄 까지 오는 데 가장 큰 값 찾기
		for(int i=1;i<=temp;i++){
			if(dp[temp][i]>sum) sum=dp[temp][i];
		}
		System.out.println(sum);
	}
}
