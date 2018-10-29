import java.util.Scanner;
//답은 나왔는데 시간이 말도 안되게 많이 걸렸다.. 2500s가 넘는다니..
//다른 방법의 최적화가 필요... 공부를 안해서 퇴보한건가..
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();

		for (int i = 0; i < loop; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int S = sc.nextInt();

			int countA = 0, countB = 0;

			int maxV = a > b ? a : b;
			int minV = a < b ? a : b;
			int totalCount = Integer.MAX_VALUE;
			for (int j = 0; j <= (S/maxV); j++) {
				if((S-(maxV*j)) % minV == 0){
					if(totalCount > j + ((S-(maxV*j)) / minV)) {
						countA = j;
						countB = (S-(maxV*j)) / minV;
						totalCount = countA + countB;
					}
				}
			}
			if(totalCount == Integer.MAX_VALUE) {
				System.out.println("Impossible");
			}else {
				if(a == maxV) {
					System.out.println(countA + " "+ countB);
				}else {
					System.out.println(countB + " "+ countA);
				}
			}
		}
		sc.close();
	}
}
