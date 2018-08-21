import java.util.Scanner;

public class Main{
  private int INF = 10000000;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt();
    int[][] graph = new int[V+1][];
    int[] weight = new int[V+1];
    Arrays.fill(weight, )
    int E = sc.nextInt();
    int start = sc.nextInt();
    int u, v;
    for(int i=1; i<=E;i++){
      u = sc.nextInt();
      v = sc.nextInt();
      graph[u][v] = sc.nextInt();
    }
    Dijkstra(start);
    for(int i= 1;i<=V;i++){
      System.out.println(weight[i]);
    }
  }
  public static void Dijkstra(){

  }
}
