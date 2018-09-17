import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] code1 = {500, 300, 200, 50, 30, 10};
	static int[] code2 = {512, 256, 128, 64, 32};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			String input = br.readLine();
			String[] temp = input.split(" ");
			int comp1 = Integer.parseInt(temp[0]);
			int comp2 = Integer.parseInt(temp[1]);
			sumCompetition(comp1, comp2);
		}
	}

	public static void sumCompetition(int comp1, int comp2) {
		int test1 = 0;
		int test2 = 0;
		if(comp1 > 0 && comp1 <=22) {
			for (int i = 0; i < 6; i++) {
				if(i*(i+1)/2 < comp1 && (i+1)*(i+2)/2 >= comp1) {
					test1 = code1[i];
				}
			}
		}
		if(comp2 > 0 && comp2 <= 31) {
			for (int i = 0; i < 5; i++) {
				if(Math.pow(2, i)-1 < comp2 && Math.pow(2, i+1)-1 >= comp2 ) {
					test2 = code2[i];
				}
			}
		}
		int sum = test1 + test2;
		if(sum != 0) {
			System.out.println(sum+"0000");
		}else {
			System.out.println(sum);
		}
	}
}
