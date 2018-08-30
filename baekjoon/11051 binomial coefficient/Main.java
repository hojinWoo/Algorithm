import java.util.Scanner;

//nCk = n-1Ck + n-1Ck-1
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1 <= N <= 1000
		int K = sc.nextInt(); // 0 <= K <= N
		int[][] arr = new int[1001][N+1];

		arr[1][0] = arr[1][1] = 1;

		for (int n = 2; n <= N; n++) {
			for (int k = 0; k <= n; k++) {
				if(n == k || k==0 ) {
					arr[n][k] = 1;
				}else {
					arr[n][k] = arr[n-1][k-1] + arr[n-1][k];
				}
				arr[n][k] %= 10007;
			}
		}
		System.out.println(arr[N][K]);
	}
}
