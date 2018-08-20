import java.util.Scanner;

//DFS
//cctv for check minimal blank
public class Main{

  static int[][] arr;
  static int[][] visited;
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();
      int y = sc.nextInt();
      arr = new int[x][y];
      visited = new visited[x][y];
      for(int i=0;i<x;i++){
        for(int j=0;j<y;j++){
          int cctv = sc.nextInt();
          arr[i][j] = cctv;
          if(cctv>=1 && cctv<=5) visited[i][j] = 1;
          if(cctv==6) visited[i][j] = -1;
        }
      }

  }

  public static void search(int check, int[][] arr){

  }
}
