import java.util.Scanner;

//DFS
//cctv for check minimal blank
public class Main{

  static int[][] arr;

  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int curve = sc.nextInt();
      arr = new int[curve][3];
      for(int i=0;i<curve;i++){
        for(int j=0;j<3;j++){
          arr[i][j] = sc.nextInt();
        }
      }

  }
}
