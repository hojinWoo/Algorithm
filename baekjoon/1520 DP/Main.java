import java.util.Arrays;
import java.util.Scanner;

//DFS & DP
public class Main {
	static int M=0;
	static int N=0;
	static int[][] arr;
	static int[][] dp;

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M][N];
		dp = new int[M][N];
		for(int k=0;k<M;k++){
			Arrays.fill(dp[k], -1);
		}
		for(int i=0;i<M;i++){
			for (int j=0;j<N;j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(dfs(M-1,N-1));
//		for(int i=0;i<M;i++){
//			for (int j=0;j<N;j++){
//				System.out.print(dp[i][j]+ " ");
//			}
//			System.out.println();
//		}
	}
	public static int dfs( int x, int y){
		if(dp[x][y] != -1 ) return dp[x][y]; //값이 존재 시 return
		if(x<0 || x>=M || y<0 || y>=N) return 0;
		if(x==0 && y==0) return 1;
		
		dp[x][y] = 0;
		for(int k=0;k<4;k++){
			int X = x+dx[k];
			int Y = y+dy[k];
			if(X>=0 && X<M && Y>=0 && Y<N && arr[X][Y] > arr[x][y])
				dp[x][y] += dfs(X,Y);
		}
		return dp[x][y];
	}
}
